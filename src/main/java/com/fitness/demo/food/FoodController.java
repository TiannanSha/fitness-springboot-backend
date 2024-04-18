package com.fitness.demo.food;

import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    /**
     * display all food
     */
    @GetMapping
    public ResponseEntity<List<Food>> getAllFood() {
        return new ResponseEntity<>(foodService.getAllFood(), HttpStatus.OK);
    }

    /**
     * user get food information by food id
     * @param foodType
     * @return
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<Food> getFoodById(@PathVariable("foodType") Food.FoodType foodType) { // binds the {id} in the path to this int id
        // todo these should be retrived from a database
        return new ResponseEntity<>(foodService.getMovieByType(foodType), HttpStatus.OK);
    }

    @PostMapping(value = "food")
    public ResponseEntity<Food> createFood(@RequestBody Food food) { // binds the JSON in the request body to a muscle object
        log.info("create food: " + food);
        // todo do an insert to a database
        return new ResponseEntity<>(food, HttpStatus.OK);
    }

    @PutMapping(value = "food")
    public ResponseEntity<Food> updateFood(@RequestBody Food food) {
        log.info("update food: " + food);
        // todo do an update to a database
        return new ResponseEntity<>(food, HttpStatus.OK);
    }

    @DeleteMapping(value = "food/{foodType}")
    public ResponseEntity<Food.FoodType> deleteFood(@PathVariable Food.FoodType foodType) {
        // todo do a delete to a database
        log.info("delete muscle with id: " + foodType);
        return new ResponseEntity<>(foodType, HttpStatus.OK);
    }
}
