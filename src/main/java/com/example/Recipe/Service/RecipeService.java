package com.example.Recipe.Service;


import com.example.Recipe.Repository.RecipeRepository;
import com.example.Recipe.model.Recipe;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }
    public List<Recipe> searchRecipesByName(String name) {
        return recipeRepository.searchRecipesByName(name);
    }

    public List<Recipe> getRecipesByCategory(String category) {
        return recipeRepository.findByCategory(category);
    }

    public List<Recipe> getRecipesByLowestCookingTime() {
        return recipeRepository.findAllByOrderByCookingTimeAsc();
    }

    public void deleteRecipeById(Long id) {
        recipeRepository.deleteById(id);
    }

}
