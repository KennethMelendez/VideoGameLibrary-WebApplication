/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.videogamelibrarywebapplication.dao;

import com.sg.videogamelibrarywebapplication.model.VideoGame;
import java.util.List;

/**
 *
 * @author kmlnd
 */
public interface VideoGameLibraryDao {
   
    List<VideoGame> getAllVideoGames();
    
    VideoGame getVideoGameById(int id);
    
    void updateVideoGame(VideoGame videoGame);
    
    void removeVideoGame(VideoGame videoGame);
    
    VideoGame getVideoGameByName(String name);
}
