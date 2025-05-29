package com.methum.Ieat.service;

import com.methum.Ieat.dto.LlmResponseDto;
import com.methum.Ieat.dto.MealDto;
import com.methum.Ieat.dto.MealResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Service
public class ResponseService {

    public String getMeal(ResponseEntity<MealResponseDto> meal, Model model, ResponseEntity<LlmResponseDto> response){

        if (meal.getStatusCode().is2xxSuccessful() && response.getStatusCode().is2xxSuccessful() &&
                meal.getBody() != null && response.getBody() != null &&
                !meal.getBody().getMeals().isEmpty() && !response.getBody().getChoices().isEmpty()) {

            MealDto mealDto = meal.getBody().getMeals().get(0);
            String content = response.getBody().getChoices().get(0).getMessage().getContent();

            model.addAttribute("title", mealDto.getStrMeal());
            model.addAttribute("content", content);
            model.addAttribute("link", mealDto.getStrYoutube());
            model.addAttribute("img", mealDto.getStrMealThumb());

            model.addAttribute("ingredients", mealDto.getIngredients());
            model.addAttribute("measurements", mealDto.getMeasurements());
        }

        return "response";
    }
}





