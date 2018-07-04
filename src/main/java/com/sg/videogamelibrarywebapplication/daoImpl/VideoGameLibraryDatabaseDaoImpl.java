/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.videogamelibrarywebapplication.daoImpl;

import com.sg.videogamelibrarywebapplication.dao.VideoGameLibraryDao;
import com.sg.videogamelibrarywebapplication.mappers.Mappers.UsersMapper;
import com.sg.videogamelibrarywebapplication.mappers.Mappers.VideoGameMapper;
import com.sg.videogamelibrarywebapplication.model.User;
import com.sg.videogamelibrarywebapplication.model.VideoGame;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author kmlnd
 */
public class VideoGameLibraryDatabaseDaoImpl implements VideoGameLibraryDao {

    //declaring jdbctemplate
    JdbcTemplate jdbcTemplate;

    //setter injection
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /*=====================================================================================
        VIDEO GAMES PREPARED STATEMENTS
    =====================================================================================*/
    // Video games Prepared Statements
    private static final String SQL_GET_ALL_VIDEOGAMES = " "
            + " SELECT * FROM videogames ";

    private static final String SQL_ADD_VIDEOGAME = ""
            + " INSERT INTO videogames(title,releasedate,publisher,developer,platforms,description)"
            + " VALUES (?,?,?,?,?,?) ";

    private static final String SQL_GET_VIDEOGAMES_BY_ID = " "
            + " SELECT * FROM videogames WHERE videogameid = ? ";

    private static final String SQL_UPDATE_VIDEOGAMES = " "
            + " UPDATE videogames SET releasedate = ?, publisher = ?, developer = ?, platforms = ?, description = ?, "
            + " WHERE videogameid = ?";

    private static final String SQL_REMOVE_VIDEOGAME = "  "
            + " DELETE FROM videogames WHERE videogameid = ? ";

    private static final String SQL_GET_VIDEOGAME_BY_NAME = ""
            + " SELECT videogames WHERE title = ?  ";

    /*=====================================================================================
        Users PREPARED STATEMENTS
    =====================================================================================*/
    private static final String SQL_GET_ALL_USERS = " SELECT * FROM users ";

    private static final String SQL_GET_USER_BY_ID = ""
            + " SELECT * users WHERE usersid = ? ";

    private static final String SQL_GET_USER_BY_USERNAME = ""
            + " SELECT * users WHERE username = ? ";

    private static final String SQL_REMOVE_USER_BY_ID = ""
            + " DELETE from users WHERE userid = ? ";

    private static final String SQL_UPDATE_USER = ""
            + " UPDATE users SET firstname = ?, lastname = ? , username = ? , password = ?"
            + " WHERE userid = ? ";

    private static final String SQL_ADD_USER = " "
            + " INSERT INTO users(firstname,lastname,username,password,enabled) "
            + " VALUES (?,?,?,?,1) ";

    /*=====================================================================================
        UsersVideogames PREPARED STATEMENTS
    =====================================================================================*/
    //PREPARED STATMENTS FOR Bridge table
    private static final String SQL_USERVIDEOGAME = ""
            + " INSERT INTO usersvideogames(userid,videogamesid) VALUES(?,?) ";

    private static final String SQL_GET_VIDEOGAMES_BY_USER = ""
            + " SELECT videogameid, title, releasedate, publisher,developer,platforms,description FROM videogames v JOIN users u ON v.videogameid = u.userid WHERE userid = ? ";

    @Override
    public List<VideoGame> getAllVideoGames() {
        try {
            return jdbcTemplate.query(SQL_GET_ALL_VIDEOGAMES, new VideoGameMapper());
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public VideoGame getVideoGameById(int id) {

        try {
            return jdbcTemplate.queryForObject(SQL_GET_VIDEOGAMES_BY_ID, new VideoGameMapper(), id);
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateVideoGame(VideoGame videoGame) {
        jdbcTemplate.update(SQL_UPDATE_VIDEOGAMES,
                videoGame.getTitle(),
                videoGame.getReleaseddate(),
                videoGame.getPublisher(),
                videoGame.getDeveloper(),
                videoGame.getPlatforms(),
                videoGame.getDescription(),
                videoGame.getVideogameid()
        );
    }

    @Override
    public void removeVideoGame(VideoGame videoGame) {
        jdbcTemplate.update(SQL_REMOVE_VIDEOGAME, videoGame.getVideogameid());
    }

    @Override
    public VideoGame getVideoGameByName(String name) {
        return jdbcTemplate.queryForObject(SQL_GET_VIDEOGAME_BY_NAME, new VideoGameMapper(), name);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addVideoGame(VideoGame videoGame, int userid) {
        
        jdbcTemplate.update(SQL_ADD_VIDEOGAME,
                videoGame.getTitle(),
                videoGame.getReleaseddate(),
                videoGame.getPublisher(),
                videoGame.getDeveloper(),
                videoGame.getPlatforms(),
                videoGame.getDescription()
        );

        // geting the last id from the current object
        int videoGameid = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        videoGame.setVideogameid(videoGameid);
        addUsersVideoGame(userid, videoGame.getVideogameid());
    }

    //HELPER METHOD
    public void addUsersVideoGame(int userid, int videogameid) {
        jdbcTemplate.update(SQL_USERVIDEOGAME, userid, videogameid);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addUser(User user) {
        jdbcTemplate.update(SQL_ADD_USER,
                user.getFirstname(),
                user.getLastname(),
                user.getUsername(),
                user.getPassword()
        );

        int id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        user.setUserid(id);
    }

    @Override
    public void removeUser(User user) {
        jdbcTemplate.update(SQL_REMOVE_USER_BY_ID, user.getUserid());
    }

    @Override
    public void updateUser(User user) {
        jdbcTemplate.update(SQL_UPDATE_USER);
    }

    @Override
    public User getUserById(int id) {
        try {
            return jdbcTemplate.queryForObject(SQL_GET_USER_BY_ID, new UsersMapper(), id);
        } catch (DataAccessException ex) {
            return null;
        }

    }

    @Override
    public User getUserByUserName(String username) {
        try {
            return jdbcTemplate.queryForObject(SQL_GET_USER_BY_USERNAME, new UsersMapper(), username);
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = jdbcTemplate.query(SQL_GET_ALL_USERS, new UsersMapper());
        return putVideoGamesInUsers(users);
    }

    // helper methods
    public List<User> putVideoGamesInUsers(List<User> users) {
        for (User currentUsers : users) {
            int id = currentUsers.getUserid();
            VideoGame vg = this.getVideoGameById(id);
            currentUsers.addASingleVideoGame(vg);
        }
        return users;
    }

    @Override
    public List<VideoGame> getVideoGamesByUser(int userid) {
        try {
            return jdbcTemplate.query(SQL_GET_VIDEOGAMES_BY_USER, new VideoGameMapper(), userid);
        } catch (DataAccessException ex) {
            return null;
        }
    }

}
