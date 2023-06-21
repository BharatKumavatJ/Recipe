package com.example.Recipe.DTO;

import com.example.Recipe.model.Recipe;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class RecipeDto {
    private Recipe recipe;
}
