package com.springboot.demo_football.repository;

import com.springboot.demo_football.entity.Player;
import com.springboot.demo_football.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

}