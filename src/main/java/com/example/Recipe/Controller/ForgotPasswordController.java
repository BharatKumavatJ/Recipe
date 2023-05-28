package com.example.Recipe.Controller;


import com.example.Recipe.Service.EmailService;
import com.example.Recipe.Service.ResetPassword;
import com.example.Recipe.Service.UserService;
import com.example.Recipe.model.ResetEmail;
import com.example.Recipe.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
public class ForgotPasswordController {

    @Autowired
    UserService userService;

    @Autowired
    ResetPassword resetPassword;

    @Autowired
    EmailService emailService;

    @PostMapping("/user/resetPassword")
    public ResponseEntity resetPassword(@RequestParam("email") String userEmail) {
        User user = userService.isUserExist(userEmail);
        if (user == null) {
            return new ResponseEntity("User Not Found", HttpStatus.NOT_FOUND);
        }
        String token = UUID.randomUUID().toString();
        resetPassword.createPasswordResetTokenForUser(user, token);
        String Status = emailService.sendResetMail(userEmail, token);
        return new ResponseEntity(Status, HttpStatus.OK);
    }

    @PostMapping("/user/verifyToken")
    public ResponseEntity verifyToken(@RequestParam("token") String token){
        Boolean isTokenValid = resetPassword.verifyToken(token);
        if(isTokenValid){
            return new ResponseEntity("True", HttpStatus.FOUND);
        }
        return new ResponseEntity("False", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/user/updatePassword")
    public ResponseEntity updatePassword(@RequestBody User user){
        String result = userService.updatePassword(user);
        if(result == "User Not Found"){
            return new ResponseEntity("User Not Found", HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity("Password updated Successfully", HttpStatus.OK);
        }
    }
}
