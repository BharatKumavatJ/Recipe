package com.example.Recipe.Service;

import com.example.Recipe.Repository.PassworTokenRepository;
import com.example.Recipe.model.PasswordResetToken;
import com.example.Recipe.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResetPasswordImpl implements ResetPassword {

    @Autowired
    PassworTokenRepository passwordTokenRepository;

    @Override
    public void createPasswordResetTokenForUser(User user, String token) {
        PasswordResetToken myToken = new PasswordResetToken(token, user);
        passwordTokenRepository.save(myToken);

    }

    @Override
    public Boolean verifyToken(String token) {
        PasswordResetToken passwordResetEntity = passwordTokenRepository.findAllByToken(token);

        if(passwordResetEntity != null) return true;
        else return false;
    }
}

