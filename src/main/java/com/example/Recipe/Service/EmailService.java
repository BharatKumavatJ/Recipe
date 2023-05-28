package com.example.Recipe.Service;

import com.example.Recipe.model.ResetEmail;

public interface EmailService {
    String sendResetMail(String email, String token);
}
