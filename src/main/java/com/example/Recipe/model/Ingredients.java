package com.example.Recipe.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
@Setter
@Entity
@Table(name = "Ingredients")
public class Ingredients {


    @Id
    @GeneratedValue // auto increment
    private Long id;
    private String ingredient;
    private String measurement;

}
