package com.saraya.springjpa.controller;

import com.saraya.springjpa.dto.PlayerDto;
import com.saraya.springjpa.model.Player;
import com.saraya.springjpa.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.saraya.springjpa.service.PlayerService;

@Controller
@RequestMapping("players")
public class PlayerController {

    @Autowired
    private PlayerService service;

    @Autowired
    private TeamService teamService;

    @GetMapping
    public String getAllPlayers(ModelMap model) {
        model.put("players", service.getAllPlayers());
        return "players/index";
    }

    @PostMapping(value="")
    public String createPlayer(@ModelAttribute("player") PlayerDto dto) {
        if (dto.getId() == 0) {
            service.createPlayer(dto);
        }else {
            service.editPlayer(dto);
        }
        return "redirect:/players";
    }

    @GetMapping("/new")
    public String playerForm(ModelMap model) {
        model.put("player", new PlayerDto());
        model.put("teams", teamService.getAllTeams());
        return "players/form-player";
    }

    @GetMapping(value="/{id}")
    public String getOnePlayer(@PathVariable Integer id) {
        return "players/details";
    }
        
    @GetMapping(value="/{id}/edit")
    public String editFormPlayer(@PathVariable Integer id, ModelMap model) {
        model.put("player", service.getPlayer(id));
        return "players/form";
    }
    
    @GetMapping(value="/{id}/delete")
    public String deletePlayer(@PathVariable Integer id) {
        service.deletePlayer(id);
        return "redirect:/players";
    }
}
