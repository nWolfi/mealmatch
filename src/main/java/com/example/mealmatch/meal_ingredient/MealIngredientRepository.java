package com.example.mealmatch.meal_ingredient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface MealIngredientRepository extends JpaRepository<MealIngredient, String> {
}
