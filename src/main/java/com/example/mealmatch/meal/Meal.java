package com.example.mealmatch.meal;

import com.example.mealmatch.meal_ingredient.MealIngredient;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "\"meal\"")
public class Meal {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "meal_id", updatable = false, nullable = false)
    private String mealId;

    @Column(name = "name")
    private String name;

     @Column(nullable = true)
     @Lob()
     private byte[] image;

    @OneToMany(mappedBy = "meal", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MealIngredient> mealIngredients = new ArrayList<>();

    public void setUserId(String userId) {
        this.mealId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

     public void setImage(byte[] image) {
         this.image = image;
     }

    public void setMealIngredients(List<MealIngredient> mealIngredients) {
        this.mealIngredients = mealIngredients;
    }

    public String getUserId() {
        return mealId;
    }

    public String getName() {
        return name;
    }

     public byte[] getImage() {
         return image;
     }

    public List<MealIngredient> getMealIngredients() {
        return mealIngredients;
    }
}
