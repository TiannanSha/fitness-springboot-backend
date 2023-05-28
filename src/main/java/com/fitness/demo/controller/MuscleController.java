package com.fitness.demo.controller;

import com.fitness.demo.AjaxResponse;
import com.fitness.demo.models.Exercise;
import com.fitness.demo.models.Muscle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class MuscleController {
    @GetMapping(value = "/muscles/{id}")
    public AjaxResponse getMuscle(@PathVariable("id") int id) { // binds the {id} in the path to this int id
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
        return AjaxResponse.AjaxSuccessResponseWithData(muscle);
    }

    @PostMapping(value = "muscles")
    public AjaxResponse createMuscle(@RequestBody Muscle muscle) { // binds the JSON in the request body to a muscle object
        log.info("create muscle: " + muscle);
        // todo do an insert to a database
        return AjaxResponse.AjaxSuccessResponseNoData();
    }

    @PutMapping(value = "muscles")
    public AjaxResponse updateMuscle(@RequestBody Muscle muscle) {
        log.info("update muscle: " + muscle);
        // todo do an update to a database
        return AjaxResponse.AjaxSuccessResponseNoData();
    }

    @DeleteMapping(value = "muscles/{id}")
    public AjaxResponse deleteMuscle(@PathVariable int id) {
        // todo do a delete to a database
        log.info("delete muscle with id: " + id);
        return AjaxResponse.AjaxSuccessResponseNoData();
    }
}
