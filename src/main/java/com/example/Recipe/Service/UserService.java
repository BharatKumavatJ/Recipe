package com.example.Recipe.Service;


import com.example.Recipe.DTO.ResponseDto.UserLoginResponseDto;
import com.example.Recipe.DTO.UserLoginDto;
import com.example.Recipe.DTO.UserRegistrationDto;
import com.example.Recipe.model.User;

import java.util.ArrayList;

public interface UserService {

    User save(UserRegistrationDto userRegistrationDto);

    ArrayList<User> getUsers();

    UserLoginResponseDto ValidateUser(UserLoginDto userLoginDto);

    User isUserExist(String email);

    String updatePassword(User user);
}
