/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.videogamelibrarywebapplication.controller;

import com.sg.videogamelibrarywebapplication.service.VideoGameLibraryService;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author kmlnd
 */
@Controller
public class LibraryController {

    VideoGameLibraryService s;

    @Inject
    public LibraryController(VideoGameLibraryService s) {
        this.s = s;
    }

    @RequestMapping(value = "/library", method = RequestMethod.GET)
    public String library(Model model) {
        model.addAttribute("gameList", s.getAllVideoGames());
        return "library";
    }

}
