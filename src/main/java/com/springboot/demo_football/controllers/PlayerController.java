package com.springboot.demo_football.controllers;


import com.springboot.demo_football.entity.Player;
import com.springboot.demo_football.entity.Team;
import com.springboot.demo_football.services.PlayerService;
import com.springboot.demo_football.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;
    @Autowired
    private TeamService teamService;

    @GetMapping("/list")
    public String listPlayer(Model model) {
        model.addAttribute("players", playerService.getPlayers());
        return "players";
    }
    @GetMapping("/delete")
    public String deletePlayer(@RequestParam("playerId") int playerId) throws Exception {
        Player player = playerService.getPlayer(playerId);
        if(player == null){
            throw new Exception();
        }
        playerService.deletePlayer(playerId);
        return "redirect:/players/list";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAddPlayer(Model model){
        List<Team> teams = teamService.getTeams();
        model.addAttribute("teams",teams);
        model.addAttribute("player",new Player(null,null,new Team()));
        return "formToAddPlayer";
    }
    @PostMapping("/addPlayer")
    public String addPlayer(@ModelAttribute("player")Player player){
        String teamName = player.getTeam().getName();
        Team team = teamService.getTeamByName(teamName);
        if(team== null){
            team = new Team(teamName);
            //handle the exception
        }
        player.setTeam(team);

        playerService.addPlayer(player);
        return "redirect:/players/list";
    }
}
