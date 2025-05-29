package com.methum.Ieat.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;


@Data
public class LlmRequestDto {

    private String model;
    private List<LlmRequestMessagesDto> messages;
}
