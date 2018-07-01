/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.videogamelibrarywebapplication.daoImpl;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author kmlnd
 */
public class VideoGameLibraryDatabaseDaoImpl {

    //declaring jdbctemplate
    JdbcTemplate jdbctemplate;

    //setter injection
    public void setJdbcTemplate(JdbcTemplate jdbctemplate) {
        this.jdbctemplate = jdbctemplate;
    }

    //Prepared Statements
}
