package com.methum.Ieat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MealDto {

    private Long idMeal;
    private String strMeal;
    private String strMealAlternate;
    private String strCategory;
    private String strArea;
    private String strInstructions;
    private String strMealThumb;
    private String strTags;
    private String strYoutube;
    private String strIngredient1;
    private String strIngredient2;
    private String strIngredient3;
    private String strIngredient4;
    private String strIngredient5;
    private String strIngredient6;
    private String strIngredient7;
    private String strIngredient8;
    private String strIngredient9;
    private String strIngredient10;
    private String strIngredient11;
    private String strIngredient12;
    private String strIngredient13;
    private String strIngredient14;
    private String strIngredient15;
    private String strIngredient16;
    private String strIngredient17;
    private String strIngredient18;
    private String strIngredient19;
    private String strIngredient20;
    private String strMeasure1;
    private String strMeasure2;
    private String strMeasure3;
    private String strMeasure4;
    private String strMeasure5;
    private String strMeasure6;
    private String strMeasure7;
    private String strMeasure8;
    private String strMeasure9;
    private String strMeasure10;
    private String strMeasure11;
    private String strMeasure12;
    private String strMeasure13;
    private String strMeasure14;
    private String strMeasure15;
    private String strMeasure16;
    private String strMeasure17;
    private String strMeasure18;
    private String strMeasure19;
    private String strMeasure20;
    private String strSource;
    private String strImageSource;
    private String strCreativeCommonsConfirmed;
    private LocalDate dateModified;

    public List<String> getIngredients() {
        List<String> ingredients = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            try {
                Field field = this.getClass().getDeclaredField("strIngredient" + i);
                field.setAccessible(true);
                String value = (String) field.get(this);
                if (value != null && !value.isBlank()) {
                    ingredients.add(value.trim());
                }
            } catch (Exception ignored) {}
        }
        return ingredients;
    }

    public List<String> getMeasurements() {
        List<String> measurements = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            try {
                Field field = this.getClass().getDeclaredField("strMeasure" + i);
                field.setAccessible(true);
                String value = (String) field.get(this);
                if (value != null && !value.isBlank()) {
                    measurements.add(value.trim());
                }
            } catch (Exception ignored) {}
        }
        return measurements;
    }
}
