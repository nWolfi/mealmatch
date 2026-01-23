package com.example.mealmatch.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController()
@RequestMapping("/meal")
public class MealController {

    private  final MealService mealService;

    private static final Logger log =
            LoggerFactory.getLogger(MealController.class);

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @PostMapping()
    public Meal createMeal(@RequestPart("meal") CreateMealDto createMealDto, @RequestPart("image")MultipartFile image) throws IOException {

        return this.mealService.createMeal(createMealDto , image.getBytes());
    }


    @GetMapping("/{id}")
    public Optional<Meal> getMealById(@PathVariable("id") String mealId){
        return this.mealService.getMealById(mealId);
    }

    @GetMapping("/random")
    public Optional<Meal> getRandomMeal(){
        return this.mealService.getRandomMeal();
    }
}
