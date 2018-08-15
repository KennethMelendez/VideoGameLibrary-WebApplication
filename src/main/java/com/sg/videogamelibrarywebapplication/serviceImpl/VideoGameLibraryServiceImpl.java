/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.videogamelibrarywebapplication.serviceImpl;

import com.sg.videogamelibrarywebapplication.dao.VideoGameLibraryDao;
import com.sg.videogamelibrarywebapplication.model.User;
import com.sg.videogamelibrarywebapplication.model.VideoGame;
import com.sg.videogamelibrarywebapplication.service.VideoGameLibraryService;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author kmlnd
 */
public class VideoGameLibraryServiceImpl implements VideoGameLibraryService{

    VideoGameLibraryDao dao;

    @Inject
    public VideoGameLibraryServiceImpl(VideoGameLibraryDao dao) {
        this.dao = dao;
    }

    @Override
    public List<VideoGame> getAllVideoGames() {
        return dao.getAllVideoGames();
    }

    @Override
    public VideoGame getVideoGameById(int id) {
        return dao.getVideoGameById(id);
    }

    @Override
    public void addVideoGame(VideoGame videoGame, int userid) {
        dao.addVideoGame(videoGame, userid);
    }

    @Override
    public void updateVideoGame(VideoGame videoGame) {
       dao.updateVideoGame(videoGame);
    }

    @Override
    public void removeVideoGame(VideoGame videoGame) {
        dao.removeVideoGame(videoGame);
    }

    @Override
    public VideoGame getVideoGameByName(String name) {
        return dao.getVideoGameByName(name);
    }

    @Override
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    public void removeUser(User user) {
        dao.removeUser(user);
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }

    @Override
    public User getUserById(int id) {
       return dao.getUserById(id);
    }

    @Override
    public User getUserByUserName(String username) {
        return dao.getUserByUserName(username);
    }

    @Override
    public List<VideoGame> getVideoGamesByUser(int userid) {
        return dao.getVideoGamesByUser(userid);
    }
    
    
    
}
