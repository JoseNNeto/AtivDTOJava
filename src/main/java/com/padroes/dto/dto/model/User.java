package com.padroes.dto.dto.model;

import java.util.List;
import java.util.Objects;

import lombok.Data;


@Data
public class User {
    private String id;
    private String name;
    private String password;
    private List<Role> roles;

    public User(String name, String password, List<Role> roles) {
        this.name = Objects.requireNonNull(name);
        this.password = this.encrypt(password);
        this.roles = Objects.requireNonNull(roles);
    }

    String encrypt(String password){
        return "Senha Criptografada";
    }

    public void addRole(Role role) {
        roles.add(role);
    }
}
