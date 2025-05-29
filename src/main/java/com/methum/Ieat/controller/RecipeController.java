package com.methum.Ieat.controller;

import com.methum.Ieat.dto.LlmResponseDto;
import com.methum.Ieat.dto.MealResponseDto;
import com.methum.Ieat.service.LlmService;
import com.methum.Ieat.service.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RecipeController {

    private final RecipeService recipeService;

    private final LlmService llmService;


    public RecipeController(RecipeService recipeService, LlmService llmService) {
        this.recipeService = recipeService;
        this.llmService = llmService;
    }


    @GetMapping("/meal")
    public ResponseEntity<MealResponseDto> getMeal(){

        ResponseEntity<MealResponseDto> responseEntity = recipeService.getMeal();

        return  responseEntity;


    }

    @PostMapping("/llm")
    public ResponseEntity<String> getCompletion() {
        ResponseEntity<MealResponseDto> responseEntity = recipeService.getMeal();
        ResponseEntity<LlmResponseDto> responseDto = llmService.getCompletion(responseEntity);
        String content = responseDto.getBody().getChoices().getFirst().getMessage().getContent();
        return new ResponseEntity<>(content,HttpStatus.OK);
    }

}
