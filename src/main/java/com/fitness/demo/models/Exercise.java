package com.fitness.demo.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Exercise {
    private String name;
    private String description;
    private String externalLink;
}
