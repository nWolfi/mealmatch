package com.example.mealmatch.ingredient;

import com.example.mealmatch.meal.MealService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController()
@RequestMapping("/ingredient")
public class IngredientController {

    public final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService){
        this.ingredientService = ingredientService;
    }

    @PostMapping()
    public Ingredient createIngredient(@RequestBody CreateIngredientDto createIngredientDto){
        return this.ingredientService.createIngredient(createIngredientDto);
    }

    @GetMapping()
    public Optional<Ingredient> getIngredientById(@PathVariable String id){
        return this.ingredientService.getIngredientById(id);
    }
}
