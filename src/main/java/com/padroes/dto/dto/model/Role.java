package com.padroes.dto.dto.model;

import lombok.Data;

@Data
public class Role {
    private String id;
    private String name;

    public Role(String name) {
        this.name = name;
    }
}
