package com.methum.Ieat.service;

import com.methum.Ieat.dto.LlmRequestDto;
import com.methum.Ieat.dto.LlmRequestMessagesDto;
import com.methum.Ieat.dto.LlmResponseDto;
import com.methum.Ieat.dto.MealResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LlmService {

    private final RestTemplate restTemplate;



    public LlmService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

    }

    final String baseUrl = "https://openrouter.ai/api/v1/chat/completions";

    @Value("${openrouter.api.key}")
    String apiKey;

   /* String prompt = "Given the following meal data including name, category, area (origin country), instructions, ingredients with measurements, and optional tags or YouTube link, generate a single paragraph summary that:\n" +
            "\n" +
            "    Briefly explains how the dish is made (summarize the instructions).\n" +
            "\n" +
            "    Mentions who it may be suitable for (e.g., vegetarians, people with dietary restrictions).\n" +
            "\n" +
            "    Notes any potential cautions (e.g., allergens, high sodium).\n" +
            "\n" +
            "    Adds any culturally relevant or interesting facts, if applicable.\n" +
            "    Keep the response clear and informative, avoiding headings or markdown. Do not include a separate title — just return a single paragraph summary.";
     */
    public ResponseEntity<LlmResponseDto> getCompletion(ResponseEntity<MealResponseDto> mealResponseDto){


        LlmRequestDto requestDto = getRequestDto(mealResponseDto);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);



        HttpEntity<LlmRequestDto> entity = new HttpEntity<>(requestDto,headers);

        ResponseEntity<LlmResponseDto> response = restTemplate.exchange(
                baseUrl,
                HttpMethod.POST,
                entity,
                LlmResponseDto.class
        );

        if (response.getStatusCode().is2xxSuccessful() && response.getBody()!=null){
            return ResponseEntity.ok(response.getBody());
        }

        return null;


    }

    private static LlmRequestDto getRequestDto(ResponseEntity<MealResponseDto> meal) {
        String prompt = "Given the following meal data including name, category, area (origin country), instructions, ingredients with measurements, and optional tags or YouTube link, generate a single paragraph summary that:\n" +
                "\n" +
                "    Briefly explains how the dish is made (summarize the instructions).\n" +
                "\n" +
                "    Mentions who it may be suitable for (e.g., vegetarians, people with dietary restrictions).\n" +
                "\n" +
                "    Notes any potential cautions (e.g., allergens, high sodium).\n" +
                "\n" +
                "    Adds any culturally relevant or interesting facts, if applicable.\n" +
                "    Keep the response clear and informative, avoiding headings or markdown. Do not include a separate title — just return a single paragraph summary.";

        LlmRequestMessagesDto messagesDto = new LlmRequestMessagesDto();
        messagesDto.setRole("user");
        messagesDto.setContent(prompt + meal);
        LlmRequestDto requestDto = new LlmRequestDto();
        requestDto.setMessages(List.of(messagesDto));
        requestDto.setModel("mistralai/devstral-small:free");
        return requestDto;
    }
}
