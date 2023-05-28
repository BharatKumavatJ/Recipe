package com.example.Recipe.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResetEmail {
    // Class data members
    private String recipient;
    private String msgBody;
    private String subject;
}

