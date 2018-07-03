/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.videogamelibrarywebapplication.mappers;

import com.sg.videogamelibrarywebapplication.model.User;
import com.sg.videogamelibrarywebapplication.model.VideoGame;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author kmlnd
 */
public class Mappers {

    // Mapper class converts rows in database into java objects
    
    public static final class VideoGameMapper implements RowMapper<VideoGame> {

        @Override
        public VideoGame mapRow(ResultSet rs, int i) throws SQLException {
            VideoGame videogame = new VideoGame();
            videogame.setVideogameid(rs.getInt("videogameid"));
            videogame.setTitle(rs.getString("title"));
            videogame.setReleaseddate(rs.getDate("releasedate"));
            videogame.setPublisher(rs.getString("publisher"));
            videogame.setDeveloper(rs.getString("developer"));
            videogame.setPlatforms(rs.getString("platforms"));
            videogame.setDescription(rs.getString("description"));
            return videogame;
        }



    }
    
    public static final class UsersMapper implements RowMapper<User>{

        @Override
        public User mapRow(ResultSet rs, int i) throws SQLException {
            User user = new User();
            user.setUserid(rs.getInt("userid"));
            user.setFirstname(rs.getString("firstname"));
            user.setLastname(rs.getString("lastname"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            return user;
        }
        
    }
}
