package com.springboot.demo_football.controllers;

import com.springboot.demo_football.entity.Player;
import com.springboot.demo_football.entity.Team;
import com.springboot.demo_football.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/team")
public class TeamController {
    @Autowired
    private PlayerService playerService;
    @Autowired
    private TeamService teamService;

    @GetMapping
    public String showTeam(@RequestParam("teamId") int teamId, Model model){
        Team team = teamService.getTeam(teamId);
        model.addAttribute("team",team);
        model.addAttribute("players",team.getPlayers());
        return "team";
    }
    @GetMapping("/showFormForAddPlayerToTeam")
    public String showFormForAddPlayer(@RequestParam("teamId") int teamId,Model model){

        Team team = teamService.getTeam(teamId);
        model.addAttribute("team",team);
        model.addAttribute("player",new Player(null,null,new Team()));
        return "formForAddPlayerToTeam";
    }
    @PostMapping("/addPlayer")
    public String addTeam(@RequestParam("teamId") int teamId, @ModelAttribute("player")Player player ){
       Team team = teamService.getTeam(teamId);
        player.setTeam(team);

        playerService.addPlayer(player);
        return "redirect:/team?teamId="+teamId;
    }
}
