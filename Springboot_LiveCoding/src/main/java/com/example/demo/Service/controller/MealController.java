package com.example.demo.Service.controller;

import com.example.demo.Service.Meal;
import com.example.demo.Service.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MealController {
    private MealService mealService;

    @Autowired
    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping(value = "/meals")
    public ResponseEntity<List<Meal>> getMeals() {
        return ResponseEntity.ok(mealService.getMeals());

    }

    @PostMapping(value = "/addMeal")
    public ResponseEntity<String> addMeal(@RequestBody Meal meal) {
        try {
            mealService.addMeal(meal);
            return ResponseEntity.ok("Meal aggiunto");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping(value = "/updateMeal")
    public ResponseEntity<String> updateName(@RequestBody Meal meal) {
        mealService.updateMeal(meal);
        return ResponseEntity.ok("Meal updated");
    }

    @DeleteMapping(value = "/meal/{mealName}")
    public ResponseEntity<String> deleteMeal(@PathVariable String mealName) {
        mealService.deleteMeal(mealName);
        return ResponseEntity.ok("Meal eliminato");
    }


}

