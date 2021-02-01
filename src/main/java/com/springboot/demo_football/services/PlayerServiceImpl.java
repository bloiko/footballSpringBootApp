package com.springboot.demo_football.services;


import com.springboot.demo_football.entity.Player;
import com.springboot.demo_football.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    @Override
    @Transactional
    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    @Override
    @Transactional
    public Player getPlayer(int playerId) {
        return playerRepository.getOne(playerId);
    }

    @Override
    @Transactional
    public void deletePlayer(int playerId) {
        playerRepository.deleteById(playerId);
    }

    @Override
    @Transactional
    public void addPlayer(Player player) {
        playerRepository.save(player);
    }

}
