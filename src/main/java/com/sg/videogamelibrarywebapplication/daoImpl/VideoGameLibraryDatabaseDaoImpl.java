/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.videogamelibrarywebapplication.daoImpl;

import com.sg.videogamelibrarywebapplication.dao.VideoGameLibraryDao;
import com.sg.videogamelibrarywebapplication.model.VideoGame;
import java.util.List;
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

    //Prepared Statements

    @Override
    public List<VideoGame> getAllVideoGames() {
        
    }

    @Override
    public VideoGame getVideoGameById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateVideoGame(VideoGame videoGame) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeVideoGame(VideoGame videoGame) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VideoGame getVideoGameByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
