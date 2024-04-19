package com.padroes.dto.dto.dto;

import java.util.List;

import lombok.Data;

@Data
public class CreateUserDTO {
    private String name;
    private String password;
    private List<String> roles;

    public CreateUserDTO(String name, String password, List<String> role) {
        this.name = name;
        this.password = password;
        this.roles = role;
    }
}
