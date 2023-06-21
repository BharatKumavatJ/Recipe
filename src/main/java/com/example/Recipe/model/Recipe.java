package com.example.Recipe.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Recipe")
public class Recipe {

    @Id
    @GeneratedValue // auto increment
    private Long id;
    private String name;
    private String category;
    private Integer preparationTime;
    private Integer cookingTime;

    @OneToMany(targetEntity = Ingredients.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe_ingredients", referencedColumnName = "id")
    private List<Ingredients> ingredientsList;




    @OneToMany(targetEntity = Instruction.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe_instruction", referencedColumnName = "id")
    private List<Instruction> instructions;


//    @OneToOne(mappedBy = "recipe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//
//    private Nutrition nutrition;


}
