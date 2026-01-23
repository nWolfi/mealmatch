package com.example.mealmatch.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class MealService {

    private final MealRepository mealRepository;

    private static final Logger log = LoggerFactory.getLogger(MealController.class);

    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public Meal createMeal(CreateMealDto createMealDto, byte[] imageBytes) {
        Meal meal = new Meal();
        meal.setName(createMealDto.name);

        this.log.error("image {}", imageBytes);

        meal.setImage(imageBytes);
        this.log.error("image {}", meal.getImage());

        return this.mealRepository.insertMeal(meal.getName(), meal.getImage()) != null ? meal : null;

    }

    public Optional<Meal> getMealById(String mealId) {
        return this.mealRepository.findById(mealId);
    }

    public long getCountOfAllMeals() {
        return mealRepository.count();
    }

    public Optional<Meal> getRandomMeal() {
        long count = getCountOfAllMeals();
        if (count == 0) {
            return Optional.empty();
        }
        int index = ThreadLocalRandom.current().nextInt(Math.toIntExact(count));

        return mealRepository.findAll(PageRequest.of(index, 1))
                .stream()
                .findFirst();
    }

    public Optional<Meal> getMealWithIngredients(String mealId) {
        return mealRepository.findById(mealId)
                .map(meal -> {
                    // Lazy-Loading der Zutaten erzwingen, falls nötig
                    meal.getMealIngredients().size();
                    return meal;
                });
    }

}
