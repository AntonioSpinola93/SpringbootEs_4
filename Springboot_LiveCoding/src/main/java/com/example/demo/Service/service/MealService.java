package com.example.demo.Service.service;

import com.example.demo.Service.Meal;
import com.example.demo.Service.dao.MealDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  La classe Service gestisce la logica di business dell applicazione.
 *  Detta le regole logiche per far si che l interazione dell utente con il programma venga regolamentata.
 */

@Service
public class MealService {
    private MealDao mealDao;
    @Autowired
    public MealService(MealDao mealDao){
        this.mealDao=mealDao;
    }
    public void addMeal(Meal meal){
        if (meal==null) throw new IllegalArgumentException("Meal cannot be null!");
        if (meal.getName()==null||meal.getName().isEmpty())throw new IllegalArgumentException("Error in meal name ! cannot be null or empty");
        if (meal.getDescription()==null||meal.getDescription().isEmpty())throw new IllegalArgumentException("Description cannot be empty or null");
        if (meal.getPrice()<=0)throw new IllegalArgumentException("Price can t be 0 or less");
        if (meal.getPrice()>100)throw new IllegalArgumentException("Price exceed the max value");
        mealDao.addMeal(meal);

    }
    public void deleteMeal(String mealName){
        mealDao.deleteMeal(mealName);

    }
    public void updateMeal(Meal meal){
        mealDao.updateMeal(meal);

    }
    public List<Meal> getMeals(){
        return mealDao.getMeals();

    }
}
