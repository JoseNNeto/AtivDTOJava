package com.padroes.dto.dto.domain;

import org.springframework.stereotype.Service;

import com.padroes.dto.dto.model.Role;

import java.util.Objects;

@Service
public class RoleService {

    private RoleRepository repository;

    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    public Role getOrCreate(String name) {
        Role role = repository.getRoleByName(name);

        if (role == null) {
            role = new Role(name);
            repository.save(role);
        }

        return role;
    }

    public void save(Role role) {
        Objects.requireNonNull(role);
        repository.save(role);
    }

    public Role getRoleByName(String id) {
        return repository.getRoleByName(id);
    }

}
