package com.example.mealmatch.meal_ingredient;

import com.example.mealmatch.ingredient.Ingredient;
import com.example.mealmatch.meal.Meal;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "meal_ingredient")
public class MealIngredient {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "meal_ingredient_id", updatable = false, nullable = false)
    private String mealIngredientId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meal_id")
    private Meal meal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;
}
