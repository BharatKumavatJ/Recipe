package com.example.Recipe.Repository;

import com.example.Recipe.model.Recipe;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    @Query("SELECT r FROM Recipe r WHERE r.name LIKE %:name%")
    List<Recipe> searchRecipesByName(@Param("name") String name);

    List<Recipe> findByCategory(String category);


    List<Recipe> findAllByOrderByCookingTimeAsc();
}
