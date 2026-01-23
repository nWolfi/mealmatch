package com.example.mealmatch.meal;

import com.example.mealmatch.meal_ingredient.MealIngredient;
import jakarta.persistence.*;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "\"meal\"")
public class Meal {

    @Id
    @Column(name = "meal_id", nullable = false, updatable = false, columnDefinition = "uuid DEFAULT uuid_generate_v4()")
    @Generated(GenerationTime.INSERT) // ID wird bei Insert von DB generiert
    private String mealId;


    @Column(name = "name")
    private String name;

    @Lob
    @Column( nullable = true)
    private byte[] image;

    @OneToMany(mappedBy = "meal", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MealIngredient> mealIngredients = new ArrayList<>();


    public void setName(String name) {
        this.name = name;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void setMealIngredients(List<MealIngredient> mealIngredients) {
        this.mealIngredients = mealIngredients;
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
