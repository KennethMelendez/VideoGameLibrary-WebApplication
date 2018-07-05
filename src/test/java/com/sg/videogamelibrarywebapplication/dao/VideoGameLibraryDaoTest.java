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
     * Test of getVideoGameById method, of class VideoGameLibraryDao.
     */
    @Test
    public void testGetVideoGameById() {
          // creating dummy user for testing
        User user = dummyUser();
        // creting two dummy video games to add to the user
        VideoGame videoGame = dummyVideoGame();
        VideoGame videoGame2 = dummyVideoGame2();
        // adding the video game to the user
        user.addASingleVideoGame(videoGame);
        // adding the user to the database
        vglDao.addUser(user);
        // adding the video game and use to the database
        vglDao.addVideoGame(videoGame, user.getUserid());
        // addint the video game to the user and to the database
        user.addASingleVideoGame(videoGame2);
        vglDao.addVideoGame(videoGame2, user.getUserid());
        // doing unit testing to see if both video games were added to the database
        assertEquals(vglDao.getVideoGameById(videoGame.getVideogameid()).getVideogameid(),videoGame.getVideogameid());
        assertEquals(vglDao.getVideoGameById(videoGame2.getVideogameid()).getVideogameid(),videoGame2.getVideogameid());
    }

    /**
     * Test of addVideoGame method, of class VideoGameLibraryDao.
     */
    @Test
    public void testAddVideoGameGetAllVideoGames() {
        // creating dummy user for testing
        User user = dummyUser();
        // creting two dummy video games to add to the user
        VideoGame videoGame = dummyVideoGame();
        VideoGame videoGame2 = dummyVideoGame2();
        // adding the video game to the user
        user.addASingleVideoGame(videoGame);
        // adding the user to the database
        vglDao.addUser(user);
        // adding the video game and use to the database
        vglDao.addVideoGame(videoGame, user.getUserid());
        // addint the video game to the user and to the database
        user.addASingleVideoGame(videoGame2);
        vglDao.addVideoGame(videoGame2, user.getUserid());
        // doing unit testing to see if both video games were added to the database
        assertEquals(2,vglDao.getAllVideoGames().size());
       
    }

    /**
     * Test of removeVideoGame method, of class VideoGameLibraryDao.
     */
    @Test
    public void testRemoveVideoGame() {
        // creating dummy user for testing
        User user = dummyUser();
        // creting two dummy video games to add to the user
        VideoGame videoGame = dummyVideoGame();
        VideoGame videoGame2 = dummyVideoGame2();
        // adding the video game to the user
        user.addASingleVideoGame(videoGame);
        // adding the user to the database
        vglDao.addUser(user);
        // adding the video game and use to the database
        vglDao.addVideoGame(videoGame, user.getUserid());
        // addint the video game to the user and to the database
        user.addASingleVideoGame(videoGame2);
        vglDao.addVideoGame(videoGame2, user.getUserid());
        
        vglDao.removeVideoGame(videoGame);
        assertEquals(1,vglDao.getAllVideoGames().size());
    }

    /**
     * Test of getVideoGameByName method, of class VideoGameLibraryDao.
     */
    @Test
    public void testGetVideoGameByName() {
              // creating dummy user for testing
        User user = dummyUser();
        // creting two dummy video games to add to the user
        VideoGame videoGame = dummyVideoGame();
        VideoGame videoGame2 = dummyVideoGame2();
        // adding the video game to the user
        user.addASingleVideoGame(videoGame);
        // adding the user to the database
        vglDao.addUser(user);
        // adding the video game and use to the database
        vglDao.addVideoGame(videoGame, user.getUserid());
        // addint the video game to the user and to the database
        user.addASingleVideoGame(videoGame2);
        vglDao.addVideoGame(videoGame2, user.getUserid());
        
        VideoGame vgFromDB = vglDao.getVideoGameByName("Biohazard 2");
        assertEquals(videoGame2.getTitle(),vgFromDB.getTitle());
        
    }

    /**
     * Test of getAllUsers method, of class VideoGameLibraryDao.
     */
    @Test
    public void testGetAllUsersGetAUser() {
        // creating dummy user for testing
        User user = dummyUser();
        User user2 = dummyUser2();
        
       
        // creting two dummy video games to add to the user
        VideoGame videoGame = dummyVideoGame();
        VideoGame videoGame2 = dummyVideoGame2();
        // adding the video game to the user
        user.addASingleVideoGame(videoGame);
        user2.addASingleVideoGame(videoGame2);
        // adding the user to the database
        vglDao.addUser(user);
        vglDao.addUser(user2);
        // adding the video game and use to the database
        vglDao.addVideoGame(videoGame, user.getUserid());
        // addint the video game to the user and to the database
        user.addASingleVideoGame(videoGame2);
        vglDao.addVideoGame(videoGame2, user.getUserid());
        
        assertEquals(vglDao.getAllUsers().size(),2);
        User userFromDB = vglDao.getUserById(user.getUserid());
        assertEquals(userFromDB.getUserid(),user.getUserid());
    }

   

    /**
     * Test of updateUser method, of class VideoGameLibraryDao.
     */
    @Test
    public void testUpdateUserUpdateGame() {
         // creating dummy user for testing
        User user = dummyUser();
        User user2 = dummyUser2();
        
       
        // creting two dummy video games to add to the user
        VideoGame videoGame = dummyVideoGame();
        VideoGame videoGame2 = dummyVideoGame2();
        // adding the video game to the user
        user.addASingleVideoGame(videoGame);
        user2.addASingleVideoGame(videoGame2);
        // adding the user to the database
        vglDao.addUser(user);
        vglDao.addUser(user2);
        // adding the video game and use to the database
        vglDao.addVideoGame(videoGame, user.getUserid());
        // addint the video game to the user and to the database
        user.addASingleVideoGame(videoGame2);
        vglDao.addVideoGame(videoGame2, user.getUserid());
        
        String newTitle = "Resident Evil 2";
        videoGame2.setTitle(newTitle);
        vglDao.updateVideoGame(videoGame2);
        
        VideoGame videoGameFromDBUpdated = vglDao.getVideoGameById(videoGame2.getVideogameid());
        assertEquals(videoGameFromDBUpdated.getTitle(),newTitle);
        
        user.setUsername("SpongebobFan");
        vglDao.updateUser(user);
        assertEquals(vglDao.getUserById(user.getUserid()).getUsername(),user.getUsername());
    }

    /**
     * Test of getUserById method, of class VideoGameLibraryDao.
     */
    @Test
    public void testGetUserById() { // creating dummy user for testing
        User user = dummyUser();
        User user2 = dummyUser2();
        
       
        // creting two dummy video games to add to the user
        VideoGame videoGame = dummyVideoGame();
        VideoGame videoGame2 = dummyVideoGame2();
        // adding the video game to the user
        user.addASingleVideoGame(videoGame);
        user2.addASingleVideoGame(videoGame2);
        // adding the user to the database
        vglDao.addUser(user);
        vglDao.addUser(user2);
        // adding the video game and use to the database
        vglDao.addVideoGame(videoGame, user.getUserid());
        // addint the video game to the user and to the database
        user.addASingleVideoGame(videoGame2);
        vglDao.addVideoGame(videoGame2, user.getUserid());
        
        String newTitle = "Resident Evil 2";
        videoGame2.setTitle(newTitle);
        vglDao.updateVideoGame(videoGame2);
        
        User userFromDB = vglDao.getUserById(user.getUserid());
        assertEquals(userFromDB.getUserid(),user.getUserid());
    }

    /**
     * Test of getUserByUserName method, of class VideoGameLibraryDao.
     */
    @Test
    public void testGetUserByUserName() {
           User user = dummyUser();
        User user2 = dummyUser2();
        
       
        // creting two dummy video games to add to the user
        VideoGame videoGame = dummyVideoGame();
        VideoGame videoGame2 = dummyVideoGame2();
        // adding the video game to the user
        user.addASingleVideoGame(videoGame);
        user2.addASingleVideoGame(videoGame2);
        // adding the user to the database
        vglDao.addUser(user);
        vglDao.addUser(user2);
        // adding the video game and use to the database
        vglDao.addVideoGame(videoGame, user.getUserid());
        // addint the video game to the user and to the database
        user.addASingleVideoGame(videoGame2);
        vglDao.addVideoGame(videoGame2, user.getUserid());
        
        String newTitle = "Resident Evil 2";
        videoGame2.setTitle(newTitle);
        vglDao.updateVideoGame(videoGame2);
        
        User userFromDB = vglDao.getUserByUserName(user.getUsername());
        assertEquals(userFromDB.getUsername(),user.getUsername());
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
   
    public VideoGame dummyVideoGame2(){
       VideoGame vg = new VideoGame();
       vg.setTitle("Biohazard 2");
       vg.setDeveloper("Capcom");
       vg.setPublisher("CAPCOM");
       vg.setPlatforms("PlayStation 4, Xbox One, Microsoft Windows");
       String customDate = "01-26-2019";
       
       SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy");
       Date da = null;
        try {
            da = ft.parse(customDate);
            vg.setReleaseddate(da);
        } catch (ParseException ex) {
            vg.setReleaseddate(da);
        }
        String description = "Resident Evil 2, known in Japan as Biohazard 2, is a survival horror game developed and published by Capcom and released for the PlayStation in 1998.";
        vg.setDescription(description);
       return vg;
   }
    
}
