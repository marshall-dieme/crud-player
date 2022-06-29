package com.saraya.springjpa.repository;

import com.saraya.springjpa.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TeamRepository {

    @PersistenceContext
    EntityManager manager;


    public Team saveTeam(Team team) {
        return manager.merge(team);
    }

    public Team getOneTeam(int id) {
        return manager.find(Team.class, id);
    }

    public void deleteTeam(Team team){
        manager.remove(team);
    }

    public List<Team> getTeams() {
        return manager.createQuery("SELECT t FROM Team t").getResultList();
    }
}
