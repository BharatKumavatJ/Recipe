package com.example.Recipe.Service;

import com.example.Recipe.model.PasswordResetToken;
import com.example.Recipe.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

public interface ResetPassword {

    public void createPasswordResetTokenForUser(User user, String token);

    public Boolean verifyToken(String token);
}
