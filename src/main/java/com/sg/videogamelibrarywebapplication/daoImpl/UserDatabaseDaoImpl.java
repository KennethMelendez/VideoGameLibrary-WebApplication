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
public class UserDatabaseDaoImpl {

    //instantiating jdbctemplate
    JdbcTemplate jdbctemplate;

    //using setter injection
    void setJdbcTemplate(JdbcTemplate jdbctemplate) {
        this.jdbctemplate = jdbctemplate;
    }

}
