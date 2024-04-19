package com.padroes.dto.dto.dto;

import java.util.List;

import lombok.Data;

@Data
public class UserDTO {
    private String name;
    private List<String> roles;

    public UserDTO(String name, List<String> roles) {
        this.name = name;
        this.roles = roles;
    }

    public UserDTO(String name) {
        this.name = name;
    }
}
