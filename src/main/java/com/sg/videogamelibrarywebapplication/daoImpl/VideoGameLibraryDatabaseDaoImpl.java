/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.videogamelibrarywebapplication.daoImpl;

import com.sg.videogamelibrarywebapplication.dao.VideoGameLibraryDao;
import com.sg.videogamelibrarywebapplication.mappers.Mappers.VideoGameMapper;
import com.sg.videogamelibrarywebapplication.model.VideoGame;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author kmlnd
 */
public class VideoGameLibraryDatabaseDaoImpl implements VideoGameLibraryDao {

    //declaring jdbctemplate
    JdbcTemplate jdbctemplate;

    //setter injection
    public void setJdbcTemplate(JdbcTemplate jdbctemplate) {
        this.jdbctemplate = jdbctemplate;
    }

    // Video games Prepared Statements
    private static final String SQL_GET_ALL_VIDEOGAMES = " "
            + " SELECT * FROM videogames ";

    private static final String SQL_ADD_VIDEOGAME = ""
            + " INSERT INTO videogames(userid,title,releasedate,publisher,developer,platforms,description)"
            + " VALUES (?,?,?,?,?,?,?) ";

    private static final String SQL_GET_VIDEOGAMES_BY_ID = " "
            + " SELECT videogames WHERE videogameid = ? ";

    private static final String SQL_UPDATE_VIDEOGAMES = " "
            + " UPDATE videogames SET userid = ? , releasedate = ?, publisher = ?, developer = ?, platforms = ?, description = ?, "
            + " WHERE videogameid = ?";

    private static final String SQL_REMOVE_VIDEOGAME = "  "
            + " DELETE FROM videogames WHERE videogameid = ? ";

    private static final String SQL_GET_VIDEOGAME_BY_NAME = ""
            + " SELECT videogames WHERE title = ?  ";

    @Override
    public List<VideoGame> getAllVideoGames() {
        try {
            return jdbctemplate.query(SQL_GET_ALL_VIDEOGAMES, new VideoGameMapper());
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public VideoGame getVideoGameById(int id) {
        return jdbctemplate.queryForObject(SQL_GET_VIDEOGAMES_BY_ID, new VideoGameMapper(), id);
    }

    @Override
    public void updateVideoGame(VideoGame videoGame) {
        jdbctemplate.update(SQL_UPDATE_VIDEOGAMES,
                videoGame.getUserid(),
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
        jdbctemplate.update(SQL_REMOVE_VIDEOGAME, videoGame.getUserid());
    }

    @Override
    public VideoGame getVideoGameByName(String name) {
        return jdbctemplate.queryForObject(SQL_GET_VIDEOGAME_BY_NAME, new VideoGameMapper(), name);
    }

    @Override
    public void addVideoGame(VideoGame videoGame) {
        jdbctemplate.update(SQL_ADD_VIDEOGAME,
                videoGame.getUserid(),
                videoGame.getTitle(),
                videoGame.getReleaseddate(),
                videoGame.getPublisher(),
                videoGame.getDeveloper(),
                videoGame.getPlatforms(),
                videoGame.getDescription()
        );

        // geting the last id from the current object
        int videoGameid = jdbctemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        videoGame.setVideogameid(videoGameid);
    }

}
