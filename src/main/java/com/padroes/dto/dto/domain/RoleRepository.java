package com.padroes.dto.dto.domain;

import com.padroes.dto.dto.model.Role;

public interface RoleRepository {
    Role getRoleById(String id);
    Role getRoleByName(String name);
    void save(Role role);
}
