package com.saraya.springjpa.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "players")
public class Player extends BaseModel {


    @Column(name = "player_name", length = 100)
    private String name;

    private int age;

    @Column(length = 50, unique = true)
    private String username;

    @ManyToOne
    private Team team;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
