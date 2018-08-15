/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.videogamelibrarywebapplication.service;

import com.sg.videogamelibrarywebapplication.model.User;
import com.sg.videogamelibrarywebapplication.model.VideoGame;
import java.util.List;

/**
 *
 * @author kmlnd
 */
public interface VideoGameLibraryService {

    List<VideoGame> getAllVideoGames();

    VideoGame getVideoGameById(int id);

    void addVideoGame(VideoGame videoGame, int userid);

    void updateVideoGame(VideoGame videoGame);

    void removeVideoGame(VideoGame videoGame);

    VideoGame getVideoGameByName(String name);

    List<User> getAllUsers();

    void addUser(User user);

    void removeUser(User user);

    void updateUser(User user);

    User getUserById(int id);

    User getUserByUserName(String username);

    List<VideoGame> getVideoGamesByUser(int userid);
}
