package com.springboot.demo_football.services;



import com.springboot.demo_football.entity.Player;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlayerService {
    List<Player> getPlayers();
    Player getPlayer(int playerId);
    void deletePlayer(int playerId);
    void addPlayer(Player player);
}
