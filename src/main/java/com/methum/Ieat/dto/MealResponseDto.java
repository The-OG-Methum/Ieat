package com.methum.Ieat.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;


@Data
public class MealResponseDto {

    private List<MealDto> meals;
}
