package com.example.Recipe.Service;

import com.example.Recipe.DTO.UserRegistrationDto;
import com.example.Recipe.Repository.UserRepository;
import com.example.Recipe.model.Role;
import com.example.Recipe.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class UserServiceimpl implements UserService{

    private UserRepository userRepository;

    public UserServiceimpl(UserRepository userRepository){
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegistrationDto registraionDto) {

        User user = new User( registraionDto.getName(), registraionDto.getPassword(), registraionDto.getEmail(),
                Arrays.asList(new Role("Role_user")));
        return userRepository.save(user);
    }

    @Override
    public ArrayList<User> getUsers() {

        ArrayList<User> users = (ArrayList<User>) userRepository.findAll();
        return users;
    }


}

