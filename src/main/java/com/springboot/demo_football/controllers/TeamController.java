package com.springboot.demo_football.controllers;

import com.springboot.demo_football.entity.Team;
import com.springboot.demo_football.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/team")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @GetMapping
    public String showTeam(@RequestParam("teamId") int teamId, Model model){
        Team team = teamService.getTeam(teamId);
        model.addAttribute("teamName",team.getName());
        model.addAttribute("players",team.getPlayers());
        return "team";
    }
}
