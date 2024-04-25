package com.fitness.demo.forms;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class ListingForm {

    @NotNull
    @Size(min=2, max=120)
    private String description;


    private double price;


    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

}
