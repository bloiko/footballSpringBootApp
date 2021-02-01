package com.springboot.demo_football.services;

import com.springboot.demo_football.entity.Team;
import com.springboot.demo_football.repository.PlayerRepository;
import com.springboot.demo_football.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamRepository teamRepository;

    @Override
    @Transactional
    public  Team getTeam(int teamId){
        return teamRepository.getOne(teamId);
    }
    @Override
    @Transactional
    public List<Team> getTeams() {
        return teamRepository.findAll();
    }
    @Override
    public Team getTeamByName(String name) {
        List<Team> list = teamRepository.findAll();
        Optional<Team> optionalTeam = list.stream().filter(tempTeam -> tempTeam.getName().equals(name)).findFirst();
        if (optionalTeam.isPresent())
            return optionalTeam.get();
        else
            return null;
    }
    @Override
    @Transactional
    public void addTeam(Team team) {
        teamRepository.save(team);
    }

}
