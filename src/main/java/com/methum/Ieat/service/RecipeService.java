package com.methum.Ieat.service;

import com.methum.Ieat.dto.MealDto;
import com.methum.Ieat.dto.MealResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RecipeService {

    private final RestTemplate restTemplate;


    public RecipeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public ResponseEntity<MealResponseDto> getMeal() {

        String baseUrl = "https://www.themealdb.com/api/json/v1/1/random.php";

        ResponseEntity<MealResponseDto> response = restTemplate.getForEntity(baseUrl,MealResponseDto.class);


        return response;

    }
}
