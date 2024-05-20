package dev.akinaksoy.rentacar.api.controllers;


import dev.akinaksoy.rentacar.business.abstracts.UserService;
import dev.akinaksoy.rentacar.business.dtos.responses.user.GetAllUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {

    private UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllUserResponse> getAllUsers(

    ){
        return userService.getAllUsers();
    }
}
