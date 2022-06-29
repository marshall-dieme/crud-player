package com.saraya.springjpa.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class TeamDto {

    private int id;

    @Size(min = 5, message = "At least 5 chars")
    @NotBlank
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
