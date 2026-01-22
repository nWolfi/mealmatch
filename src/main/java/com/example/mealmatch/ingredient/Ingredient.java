package com.example.mealmatch.ingredient;

import com.example.mealmatch.meal_ingredient.MealIngredient;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "ingredient_id", updatable = false, nullable = false)
    private String ingredientId;

    @Column(name = "name")
    private String name;

    @Column(name = "gram")
    private Integer gram;

    @Column(name = "calories_per_gram")
    private Integer caloriesPerGram;

    @OneToMany(mappedBy = "ingredient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MealIngredient> mealIngredients = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }

    public void setGram(Integer gram) {
        this.gram = gram;
    }

    public void setCaloriesPerGram(Integer caloriesPerGram) {
        this.caloriesPerGram = caloriesPerGram;
    }

    public String getName() {
        return name;
    }

    public Integer getGram() {
        return gram;
    }

    public Integer getCaloriesPerGram() {
        return caloriesPerGram;
    }
}
