package com.saraya.springjpa.service;

import java.util.List;

import com.saraya.springjpa.dto.TeamDto;
import com.saraya.springjpa.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saraya.springjpa.model.Team;

@Service
public class TeamService {

    @Autowired
    TeamRepository repository;

    public List<Team> getAllTeams() {
        return repository.getTeams();
    }

    public Team getTeam(int id) {
        return repository.getOneTeam(id);
    }

    public Team createTeam(TeamDto teamDto){
        return repository.saveTeam(toEntity(teamDto));
    }


    public void deleteTeam(Integer id) {
        repository.deleteTeam(getTeam(id ));
    }

    public TeamDto getDtoForUpdate(Integer id){
        return toDto(repository.getOneTeam(id));
    }

    public void updateTeam(TeamDto dto) {
        repository.saveTeam(toEntity(dto));
    }

    private Team toEntity(TeamDto dto){
        Team team = new Team();
        team.setId(dto.getId());
        team.setName(dto.getName());
        return team;
    }

    private TeamDto toDto(Team team){
        TeamDto dto = new TeamDto();
        dto.setId(team.getId());
        dto.setName(team.getName());
        return dto;
    }
}