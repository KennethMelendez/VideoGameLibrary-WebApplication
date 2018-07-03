/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.videogamelibrarywebapplication.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author kmlnd
 */
public class User {
    private int userid;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private List<VideoGame> videogames = new ArrayList<>();
            
    public User(){
        
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<VideoGame> getVideogames() {
        return videogames;
    }

    public void setVideogames(List<VideoGame> videogames) {
        this.videogames = videogames;
    }
    
    public void addASingleVideoGame(VideoGame videoGame){
        videogames.add(videoGame);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.userid;
        hash = 97 * hash + Objects.hashCode(this.firstname);
        hash = 97 * hash + Objects.hashCode(this.lastname);
        hash = 97 * hash + Objects.hashCode(this.username);
        hash = 97 * hash + Objects.hashCode(this.password);
        hash = 97 * hash + Objects.hashCode(this.videogames);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.userid != other.userid) {
            return false;
        }
        if (!Objects.equals(this.firstname, other.firstname)) {
            return false;
        }
        if (!Objects.equals(this.lastname, other.lastname)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.videogames, other.videogames)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
