package com.example.Recipe.Controller;

import com.example.Recipe.DTO.RecipeDto;
import com.example.Recipe.Repository.IngredientsRepository;
import com.example.Recipe.Repository.InstructionRepository;
//import com.example.Recipe.Repository.NutritionRepository;
import com.example.Recipe.Repository.NutritionRepository;
import com.example.Recipe.Repository.RecipeRepository;
import com.example.Recipe.model.Instruction;
import com.example.Recipe.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeController {


    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private IngredientsRepository ingredientsRepository;

    @Autowired
    private InstructionRepository instructionRepository;

    @Autowired
    private NutritionRepository nutritionRepository;


    @PostMapping("/AddRecipe")
    public Recipe addRecipe(@RequestBody RecipeDto recipeDto){

        System.out.print(recipeDto);

        return recipeRepository.save(recipeDto.getRecipe());


    }


}
