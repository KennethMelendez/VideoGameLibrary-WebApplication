/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.videogamelibrarywebapplication.dao;

import com.sg.videogamelibrarywebapplication.model.User;
import com.sg.videogamelibrarywebapplication.model.VideoGame;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author kmlnd
 */
public class VideoGameLibraryDaoTest {
    
    VideoGameLibraryDao vglDao;
    
    public VideoGameLibraryDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        ApplicationContext ctx = new  ClassPathXmlApplicationContext("test-applicationContext.xml");
        
        vglDao = ctx.getBean("videoGameLibraryDao",VideoGameLibraryDao.class);
        
        List<VideoGame> videoGames = vglDao.getAllVideoGames();
        List<User> users= vglDao.getAllUsers();
        
        for(VideoGame vg :videoGames){
            vglDao.removeVideoGame(vg);
        }
        
        for(User user : users){
            vglDao.removeUser(user);
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllVideoGames method, of class VideoGameLibraryDao.
     */
    @Test
    public void testGetAllVideoGames() {
    }

    /**
     * Test of getVideoGameById method, of class VideoGameLibraryDao.
     */
    @Test
    public void testGetVideoGameById() {
    }

    /**
     * Test of addVideoGame method, of class VideoGameLibraryDao.
     */
    @Test
    public void testAddVideoGame() {
        User user = dummyUser();
        VideoGame videoGame = dummyVideoGame();
        
        user.addASingleVideoGame(videoGame);
        vglDao.addUser(user);
        vglDao.addVideoGame(videoGame, user.getUserid());
        assertEquals(1,vglDao.getAllVideoGames().size());
       
    }

    /**
     * Test of updateVideoGame method, of class VideoGameLibraryDao.
     */
    @Test
    public void testUpdateVideoGame() {
    }

    /**
     * Test of removeVideoGame method, of class VideoGameLibraryDao.
     */
    @Test
    public void testRemoveVideoGame() {
    }

    /**
     * Test of getVideoGameByName method, of class VideoGameLibraryDao.
     */
    @Test
    public void testGetVideoGameByName() {
    }

    /**
     * Test of getAllUsers method, of class VideoGameLibraryDao.
     */
    @Test
    public void testGetAllUsers() {
    }

    /**
     * Test of addUser method, of class VideoGameLibraryDao.
     */
    @Test
    public void testAddUser() {
    }

    /**
     * Test of removeUser method, of class VideoGameLibraryDao.
     */
    @Test
    public void testRemoveUser() {
    }

    /**
     * Test of updateUser method, of class VideoGameLibraryDao.
     */
    @Test
    public void testUpdateUser() {
    }

    /**
     * Test of getUserById method, of class VideoGameLibraryDao.
     */
    @Test
    public void testGetUserById() {
    }

    /**
     * Test of getUserByUserName method, of class VideoGameLibraryDao.
     */
    @Test
    public void testGetUserByUserName() {
    }

    /**
     * Test of getVideoGamesByUser method, of class VideoGameLibraryDao.
     */
    @Test
    public void testGetVideoGamesByUser() {
    }

   public User dummyUser(){
       User u = new User();
       u.setUsername("Kellie Porter");
       u.setFirstname("Kellie");
       u.setLastname("Porter");
       u.setPassword("123");
       return u;
   }
   
   public User dummyUser2(){
       User u = new User();
       u.setUsername("Matt Williams");
       u.setFirstname("Matt");
       u.setLastname("Williams");
       u.setPassword("123");
       return u;
   }
   
   public VideoGame dummyVideoGame(){
       VideoGame vg = new VideoGame();
       vg.setTitle("Dragon Ball FighterZ");
       vg.setDeveloper("Arc System Works");
       vg.setPublisher("BANDAI NAMCO ENTERTAINMENT");
       vg.setPlatforms("PlayStation 4, Nintendo Switch, Xbox One, Microsoft Windows");
       String customDate = "02-26-2018";
       
       SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy");
       Date da = null;
        try {
            da = ft.parse(customDate);
            vg.setReleaseddate(da);
        } catch (ParseException ex) {
            vg.setReleaseddate(da);
        }
        String description = "Dragon Ball FighterZ is a 2.5D fighting game developed by Arc System Works and published by Bandai Namco Entertainment. ";
        vg.setDescription(description);
       return vg;
   }
    
}
