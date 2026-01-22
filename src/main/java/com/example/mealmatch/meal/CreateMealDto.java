package com.example.mealmatch.meal;

import com.example.mealmatch.ingredient.CreateIngredientDto;

import java.util.List;

public class CreateMealDto {
    public String name;
    public List<CreateIngredientDto> ingredients;
}
