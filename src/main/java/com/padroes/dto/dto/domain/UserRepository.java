package com.padroes.dto.dto.domain;

import java.util.List;

import com.padroes.dto.dto.model.User;

public interface UserRepository {
    List<User> getAll();
    void save(User user);
    void deleteAll();
}
