package com.padroes.dto.dto.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.padroes.dto.dto.domain.RoleService;
import com.padroes.dto.dto.domain.UserService;
import com.padroes.dto.dto.dto.CreateUserDTO;
import com.padroes.dto.dto.dto.UserDTO;
import com.padroes.dto.dto.model.Role;
import com.padroes.dto.dto.model.User;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
class UserController {

    private UserService userService;
    private RoleService roleService;
    private Mapper mapper;

    // Constructor
    public UserController(UserService userService, RoleService roleService, Mapper mapper) {
        this.userService = userService;
        this.roleService = roleService;
        this.mapper = mapper;
    }

    @GetMapping
    @ResponseBody
    public List<UserDTO> getUsers() {
        return userService.getAll()
          .stream()
          .map(mapper::toDto)
          .collect(Collectors.toList());
    }


    @PostMapping
    @ResponseBody
    public UserDTO create(@RequestBody CreateUserDTO userDTO) {
        User user = mapper.toUser(userDTO);

        userDTO.getRoles()
          .stream()
          .map(roleService::getOrCreate)
          .forEach(user::addRole);

        userService.save(user);

        return new UserDTO(user.getName());
    }

    public Role getRoleByName(String roleName) {
        return roleService.getOrCreate(roleName);
    }

}

