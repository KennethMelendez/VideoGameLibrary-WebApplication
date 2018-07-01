/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.videogamelibrarywebapplication.dao;

import com.sg.videogamelibrarywebapplication.model.User;

/**
 *
 * @author kmlnd
 */
public interface UserDao {

    void addUser(User user);

    void removeUser(User user);

    void updateUser(User user);

    User getUserById(int id);

    User getUserByUserName(String username);
    
}
