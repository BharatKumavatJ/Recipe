package com.example.Recipe.Controller;

import com.example.Recipe.DTO.UserRegistrationDto;
import com.example.Recipe.DTO.UserResponseDto;
import com.example.Recipe.Service.UserService;
import com.example.Recipe.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@Controller
@RequestMapping("/registration")
public class UserController {

    private UserService userService;
    public UserController(UserService userService){
        super();
        this.userService = userService;
    }


    @PostMapping("/adduser")
    public ResponseEntity addUser(@RequestBody UserRegistrationDto registrationDto){
        userService.save(registrationDto);
        return new ResponseEntity<>("user added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/getuser")
    public ResponseEntity getUser(){
        ArrayList<User> listOfUsers = userService.getUsers();

        return new ResponseEntity<>(listOfUsers, HttpStatus.FOUND);

    }
}
