/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.videogamelibrarywebapplication.controller;

import com.sg.videogamelibrarywebapplication.model.VideoGame;
import com.sg.videogamelibrarywebapplication.service.VideoGameLibraryService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author kmlnd
 */
@Controller
public class ModifyVideoGameController {

    VideoGameLibraryService s;

    @Inject
    public ModifyVideoGameController(VideoGameLibraryService s) {
        this.s = s;
    }

    @RequestMapping(value = "/addVideoGame", method = RequestMethod.GET)
    public String addVideoGame() {
        return "addVideoGame";
    }

    @RequestMapping(value = "/submitGame", method = RequestMethod.POST)
    public String submitVideoGame(HttpServletRequest request) {
        VideoGame vg = new VideoGame();
        vg.setTitle(request.getParameter("title"));
        String date = request.getParameter("date");
        SimpleDateFormat formatter = new SimpleDateFormat("mm-dd-yyyy");

        try {
            Date formatDate = formatter.parse(date);
            vg.setReleaseddate(formatDate);
        } catch (ParseException ex) {
            Logger.getLogger(ModifyVideoGameController.class.getName()).log(Level.SEVERE, null, ex);
        }

        vg.setPublisher(request.getParameter("publisher"));
        vg.setDeveloper(request.getParameter("developer"));
        vg.setPlatforms(request.getParameter("platforms"));
        vg.setDescription(request.getParameter("description"));

        s.addVideoGame(vg, s.getUserByUserName("SpongebobFan").getUserid());

        return "redirect:library";
    }

    @RequestMapping(value = "/removeGame", method = RequestMethod.GET)
    public String removeGame(HttpServletRequest request) {
        s.removeVideoGame(s.getVideoGameById(Integer.parseInt(request.getParameter("videoGameId"))));
        return "redirect:library";
    }

    @RequestMapping(value = "/editVideoGame", method = RequestMethod.GET)
    public String editVideoGame(HttpServletRequest request, Model model) {
        String requestedIdId = request.getParameter("videoGameId");
        int id = Integer.parseInt(requestedIdId);
        model.addAttribute("videoGame", s.getVideoGameById(id));
        return "editVideoGame";
    }

    @RequestMapping(value = "/submitUpdatedGame", method = RequestMethod.POST)
    public String updateGame(@ModelAttribute("VideoGame")VideoGame videoGame) {
        s.updateVideoGame(videoGame);
        return "redirect:library";
    }
}
