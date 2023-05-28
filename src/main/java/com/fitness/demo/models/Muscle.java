package com.fitness.demo.models;

import jdk.jfr.DataAmount;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Muscle {
    int id;

    // name of the muscle, e.g. bicep
    private String name;

    // exercise that can train this muscle
    private List<Exercise> exercises;
}
