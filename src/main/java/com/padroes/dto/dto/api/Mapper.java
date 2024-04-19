package com.padroes.dto.dto.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.padroes.dto.dto.dto.CreateUserDTO;
import com.padroes.dto.dto.dto.UserDTO;
import com.padroes.dto.dto.model.Role;
import com.padroes.dto.dto.model.User;
import java.util.stream.Collectors;

@Component
class Mapper {
    public UserDTO toDto(User user) {
            String name = user.getName();
            List<String> roles = user
                .getRoles()
                .stream()
                .map(Role::getName)
                .collect(Collectors.toList());

            return new UserDTO(name, roles);
    }

    public User toUser(CreateUserDTO userDTO) {
        return new User(userDTO.getName(), userDTO.getPassword(), new ArrayList<>());
    }
}