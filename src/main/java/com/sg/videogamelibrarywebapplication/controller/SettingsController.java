/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.videogamelibrarywebapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author kmlnd
 */
@Controller
public class SettingsController {
    @RequestMapping(value="/settings" , method= RequestMethod.GET)
    public String Settings(){
        
        /**
         *  Code for the settings go here
         */
        
        return "settings";
    }
}
