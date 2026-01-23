package com.example.mealmatch.meal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MealRepository extends JpaRepository<Meal, String> {

    @Query(value = "INSERT INTO meal (name, image) VALUES (:name, :image) RETURNING meal_id", nativeQuery = true)
    String insertMeal(@Param("name") String name, @Param("image") byte[] image);

}
