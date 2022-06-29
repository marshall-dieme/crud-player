package com.saraya.springjpa.controller;

import com.saraya.springjpa.dto.TeamDto;
import com.saraya.springjpa.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.saraya.springjpa.service.TeamService;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("teams")
public class TeamController {
    @Autowired
    private TeamService service;

    @GetMapping
    public String getAllTeams(ModelMap model) {
        model.put("teams", service.getAllTeams());
        return "teams/index";
    }

    @GetMapping("/new")
    public String teamForm(ModelMap model) {
        model.put("team", new TeamDto());
        return "teams/form-team";
    }

    @PostMapping(value="")
    public String createTeam(@ModelAttribute("team") @Valid TeamDto team, BindingResult result) {
        if (result.hasErrors()){
            return "teams/form-team";
        }
        if (team.getId() == 0) {
            service.createTeam(team);
        }else {
            service.updateTeam(team);
        }
        return "redirect:/teams";
    }

    @GetMapping(value="/{id}")
    public String getOneTeam(@PathVariable Integer id, ModelMap model) {
        model.put("team", service.getTeam(id));
        return "teams/details";
    }
        
    @GetMapping(value="/{id}/edit")
    public String editFormTeam(@PathVariable Integer id, ModelMap model) {
        model.put("team", service.getDtoForUpdate(id));
        return "teams/form-team";
    }

    @PostMapping(value="/{id}/edit")
    public String editTeam(@PathVariable Integer id) {
        return "teams/edit";
    }
    
    @GetMapping(value="/{id}/delete")
    public String deleteTeam(@PathVariable Integer id) {
        service.deleteTeam(id);
        return "redirect:/teams";
    }
    
}
