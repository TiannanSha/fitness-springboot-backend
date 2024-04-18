package com.fitness.demo.food;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Food {
    public enum FoodType {
        Chicken,
        Beef,
        Pork,
        Salmon,
        Pasta,
        Rice,
        Cereal
    }

    FoodType foodType;
    String name;
    double caloryPerGram;
    double proteinPerGram;
}
