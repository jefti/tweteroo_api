package com.tweteroo.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TweetDTO {
    @NotNull
    @Positive
    private long userId;
    
    @NotBlank
    @Size(max = 280, message = "O tweet não pode conter mais que 280 caracteres.")
    private String tweet;
}
