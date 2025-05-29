package com.methum.Ieat.dto;

import lombok.Data;

import java.util.List;


@Data
public class LlmResponseDto {

    private String id;
    private List<ChoicesDto> choices;
}
