package com.example.mealmatch.ingredient;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }

    public Optional<Ingredient> getIngredientById(String id){
        return this.ingredientRepository.findById(id);
    }

    public Ingredient createIngredient(CreateIngredientDto createIngredientDto){
        Ingredient ingredient = new Ingredient();
        ingredient.setName(createIngredientDto.name);
        ingredient.setGram(createIngredientDto.gram);
        ingredient.setCaloriesPerGram(createIngredientDto.caloriesPerGram);

        return this.ingredientRepository.save(ingredient);
    }
}
