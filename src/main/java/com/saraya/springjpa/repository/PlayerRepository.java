package com.saraya.springjpa.repository;

import com.saraya.springjpa.model.Player;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PlayerRepository {

    @PersistenceContext
    EntityManager manager;


    public Player savePlayer(Player player) {
        return manager.merge(player);
    }

    public Player getOnePlayer(int id) {
        return manager.find(Player.class, id);
    }

    public void deletePlayer(Player player){
        manager.remove(player);
    }

    public List<Player> getPlayers() {
        return manager.createQuery("SELECT t FROM Player t").getResultList();
    }
}
