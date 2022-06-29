package com.saraya.springjpa.service;

import java.util.List;

import com.saraya.springjpa.dto.PlayerDto;
import com.saraya.springjpa.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saraya.springjpa.model.Player;

@Service
public class PlayerService {

    @Autowired
    private TeamService teamService;

    @Autowired
    private PlayerRepository repo;

    
    public List<Player> getAllPlayers() {
        return repo.getPlayers();
    }

    public Player getPlayer(int id) {
        return repo.getOnePlayer(id);
    }

    public Player createPlayer(PlayerDto dto){
        return repo.savePlayer(toEntity(dto));
    }

    public Player editPlayer(PlayerDto player) {
        return repo.savePlayer(toEntity(player));
    }

    public void deletePlayer(int id) {
        repo.deletePlayer(getPlayer(id));
    }

    private Player toEntity(PlayerDto dto){
        Player player = new Player();
        player.setName(dto.getName());
        player.setAge(dto.getAge());
        player.setUsername(dto.getUsername());
        player.setTeam(teamService.getTeam(dto.getTeamId()));
        return player;
    }

    private PlayerDto toDto(Player player) {
        PlayerDto dto = new PlayerDto();
        dto.setId(player.getId());
        dto.setName(player.getName());
        dto.setAge(player.getAge());
        dto.setUsername(player.getUsername());
        dto.setTeamId(player.getTeam().getId());

        return dto;
    }
}