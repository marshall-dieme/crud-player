package com.saraya.springjpa.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teams")
public class Team extends BaseModel {

    private String name;


    @OneToMany
    private List<Player> players;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
