package com.example.Recipe.Controller;

import com.example.Recipe.DTO.RecipeDto;
import com.example.Recipe.Repository.IngredientsRepository;
import com.example.Recipe.Repository.InstructionRepository;
//import com.example.Recipe.Repository.NutritionRepository;
import com.example.Recipe.Repository.NutritionRepository;
import com.example.Recipe.Repository.RecipeRepository;
import com.example.Recipe.Service.RecipeService;
import com.example.Recipe.model.Instruction;
import com.example.Recipe.model.Nutrition;
import com.example.Recipe.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recipe")
@CrossOrigin
public class RecipeController {


    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private IngredientsRepository ingredientsRepository;

    @Autowired
    private InstructionRepository instructionRepository;

    @Autowired
    private NutritionRepository nutritionRepository;


    @Autowired
    private RecipeService recipeService;

    @PostMapping("/AddRecipe")
    public Recipe addRecipe(@RequestBody RecipeDto recipeDto){
        return recipeRepository.save(recipeDto.getRecipe());
    }


    @GetMapping("/getAll")
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @GetMapping("/search")
    public List<Recipe> searchRecipesByName(@RequestParam String name) {
        return recipeService.searchRecipesByName(name);
    }

    @GetMapping("/category/{category}")
    public List<Recipe> getRecipesByCategory(@PathVariable String category) {
        return recipeService.getRecipesByCategory(category);
    }

    @GetMapping("/lowest-cooking-time")
    public List<Recipe> getRecipesByLowestCookingTime() {
        return recipeService.getRecipesByLowestCookingTime();
    }

}
