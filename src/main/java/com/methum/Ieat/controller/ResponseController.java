package com.methum.Ieat.controller;

import com.methum.Ieat.dto.LlmResponseDto;
import com.methum.Ieat.dto.MealResponseDto;
import com.methum.Ieat.service.LlmService;
import com.methum.Ieat.service.RecipeService;
import com.methum.Ieat.service.ResponseService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.List;

@Controller
public class ResponseController {

    private final RecipeService recipeService;

    private final LlmService llmService;

    private final ResponseService responseService;

    public ResponseController(RecipeService recipeService, LlmService llmService, ResponseService responseService) {
        this.recipeService = recipeService;
        this.llmService = llmService;
        this.responseService = responseService;
    }

    @GetMapping ("/meal")
    public String getCompletion(Model model) {
        ResponseEntity<MealResponseDto> responseEntity = recipeService.getMeal();
        System.out.println(responseEntity.getBody().getMeals().getFirst().getStrYoutube());
        ResponseEntity<LlmResponseDto> responseDto = llmService.getCompletion(responseEntity);


        return responseService.getMeal(responseEntity,model,responseDto);
    }
}
