package com.example.Recipe.Service;

import com.example.Recipe.DTO.ResponseDto.UserLoginResponseDto;
import com.example.Recipe.DTO.UserLoginDto;
import com.example.Recipe.DTO.UserRegistrationDto;
import com.example.Recipe.Repository.UserRepository;
import com.example.Recipe.model.Role;
import com.example.Recipe.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class UserServiceimpl implements UserService{

    /**
     * This class implements user service layer.
     */
    @Autowired
    private PasswordEncoder passwordEncoder;

    private UserRepository userRepository;

    public UserServiceimpl(UserRepository userRepository){
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegistrationDto registraionDto) {

        User user = new User(
                registraionDto.getName(),
                passwordEncoder.encode(registraionDto.getPassword()),
                registraionDto.getEmail(),
                Arrays.asList(new Role("Role_user")));
         userRepository.save(user);
        return user;
    }

    @Override
    public ArrayList<User> getUsers() {

        ArrayList<User> users = (ArrayList<User>) userRepository.findAll();
        return users;
    }

    @Override
    public UserLoginResponseDto ValidateUser(UserLoginDto userLoginDto) {

        String requestedPassword = userLoginDto.getPassword();
        String requestedUserEmail = userLoginDto.getEmail();
        System.out.print("email and password" +  requestedUserEmail + " " + requestedPassword);
        User userFromDatabase = userRepository.findByEmail(requestedUserEmail);


        if(userFromDatabase != null){

            String encodedPassword = userFromDatabase.getPassword();
            String storedEmail = userFromDatabase.getEmail();

            if(storedEmail.equals(requestedUserEmail)){
                if(passwordEncoder.matches( requestedPassword, encodedPassword)){
                    return new UserLoginResponseDto("Valid User", true);
                }else{
                    return new UserLoginResponseDto("Invalid Password", false);
                }
            }else{
                return new UserLoginResponseDto("User does not exist", false);
            }
        }else{
            return new UserLoginResponseDto("User does not exist", false);
        }
    }

    @Override
    public User isUserExist(String email) {
        User userFromDatabase = userRepository.findByEmail(email);
        return userFromDatabase;
    }

    @Override
    public String updatePassword(User user) {
        User userInDatabase  = userRepository.findByEmail(user.getEmail());
        if (userInDatabase!= null) {
            userInDatabase.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(userInDatabase);
            return "Password Updated SuccessFully";
        }else{
            return "User Not Found";
        }
    }

}

