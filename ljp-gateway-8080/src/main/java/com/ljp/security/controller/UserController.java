package com.ljp.security.controller;

import com.ljp.common.entity.Result;
import com.ljp.security.dto.UserDTO;
import com.ljp.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/security/user/addUserDTO")
    public Mono<Result> addUserDTO(UserDTO userDTO) {
        return Mono.just(userService.addUserDTO(userDTO));
    }

    @GetMapping("/security/user/getUserDTO")
    public Mono<Result> getUserDTO(Long id) {
        return Mono.just(userService.getUserDTO(id));
    }

    @DeleteMapping("/security/user/deleteUserDTO")
    public Mono<Result> deleteUserDTO(Long id) {
        return Mono.just(userService.deleteUserDTO(id));
    }

}
