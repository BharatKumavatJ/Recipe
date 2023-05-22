package com.example.Recipe.Service;


import com.example.Recipe.DTO.UserRegistrationDto;
import com.example.Recipe.model.User;

import java.util.ArrayList;

public interface UserService {

    User save(UserRegistrationDto userRegistrationDto);

    ArrayList<User> getUsers();
}
