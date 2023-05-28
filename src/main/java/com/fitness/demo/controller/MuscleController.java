package com.fitness.demo.controller;

import com.fitness.demo.AjaxResponse;
import com.fitness.demo.models.Exercise;
import com.fitness.demo.models.Muscle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class MuscleController {
    @GetMapping(value = "/muscles/{id}")
    public AjaxResponse getMuscle(@PathVariable("id") int id) {
        // todo these should be retrived from a database
        List<Exercise> exercises = new ArrayList<>();
        exercises.add(Exercise.builder().name("dumbbell-curl").build());
        exercises.add(Exercise.builder().name("pull-up").build());
        Muscle muscle = Muscle.builder().
                id(id).
                name("bicep").
                exercises(exercises).
                build();
        log.info("muscle: " + muscle);
        return AjaxResponse.createAjaxForGetRequest(muscle);
    }
}
