package com.fitness.demo.eating.entry;

import com.fitness.demo.food.Food;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
@NoArgsConstructor
public class EatingEntry {
    String foodType;
    double amountByGram;
    Timestamp timestamp;
    String pattern = "yyyy-MM-dd HH:mm:ss";

    public EatingEntry(String foodType, double amountByGram, String timestampStr) {
        this.foodType = foodType;
        this.amountByGram = amountByGram;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime dateTime = LocalDateTime.parse(timestampStr, formatter);
        this.timestamp = Timestamp.valueOf(dateTime);
    }
}
