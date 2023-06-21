package com.example.Recipe.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Nutrition {


    @Id
    @GeneratedValue// auto increment
    private Long id;
    private String calories;
    private String fat;
    private String protein;
    private String carbohydrates;


//    @OneToOne(targetEntity = Recipe.class, fetch = FetchType.EAGER)
//    @JoinColumn(nullable = false, name = "recipe_id")
//    private Recipe recipe;
}
