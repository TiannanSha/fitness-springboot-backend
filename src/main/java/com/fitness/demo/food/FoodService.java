package com.fitness.demo.food;

import com.fitness.demo.food.Food;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FoodService {
    public static final Map<Food.FoodType, Food> allFood = new HashMap<>();

    static {
        allFood.put(Food.FoodType.Beef, Food.builder().
                foodType(Food.FoodType.Beef).
                caloryPerGram(250).build());
        allFood.put(Food.FoodType.Chicken, Food.builder().foodType(Food.FoodType.Chicken).caloryPerGram(230).build());
        allFood.put(Food.FoodType.Salmon, Food.builder().foodType(Food.FoodType.Salmon).caloryPerGram(240).build());
    }

    public List<Food> getAllFood() {
        return allFood.values().stream().toList();
    }

    public Food getMovieByType(Food.FoodType foodType) {
        return allFood.get(foodType);
    }
}
