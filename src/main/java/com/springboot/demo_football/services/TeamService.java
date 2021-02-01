package com.springboot.demo_football.services;

import com.springboot.demo_football.entity.Player;
import com.springboot.demo_football.entity.Team;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeamService {
    Team getTeam(int teamId);
    List<Team> getTeams();
    Team getTeamByName(String name);
    void addTeam(Team team);
}
