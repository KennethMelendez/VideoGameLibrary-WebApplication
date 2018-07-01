/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.videogamelibrarywebapplication.model;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author kmlnd
 */
public class VideoGame {
    private int videogameid;
    private int userid;
    private String title;
    private Date releaseddate;
    private String publisher;
    private String developer;
    private String platforms;
    private String description;
    
    public VideoGame(){
        
    }

    public int getVideogameid() {
        return videogameid;
    }

    public void setVideogameid(int videogameid) {
        this.videogameid = videogameid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseddate() {
        return releaseddate;
    }

    public void setReleaseddate(Date releaseddate) {
        this.releaseddate = releaseddate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getPlatforms() {
        return platforms;
    }

    public void setPlatforms(String platforms) {
        this.platforms = platforms;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.videogameid;
        hash = 71 * hash + this.userid;
        hash = 71 * hash + Objects.hashCode(this.title);
        hash = 71 * hash + Objects.hashCode(this.releaseddate);
        hash = 71 * hash + Objects.hashCode(this.publisher);
        hash = 71 * hash + Objects.hashCode(this.developer);
        hash = 71 * hash + Objects.hashCode(this.platforms);
        hash = 71 * hash + Objects.hashCode(this.description);
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
        final VideoGame other = (VideoGame) obj;
        if (this.videogameid != other.videogameid) {
            return false;
        }
        if (this.userid != other.userid) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.publisher, other.publisher)) {
            return false;
        }
        if (!Objects.equals(this.developer, other.developer)) {
            return false;
        }
        if (!Objects.equals(this.platforms, other.platforms)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.releaseddate, other.releaseddate)) {
            return false;
        }
        return true;
    }
    
    
}
