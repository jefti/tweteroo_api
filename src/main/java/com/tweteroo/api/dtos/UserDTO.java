package com.tweteroo.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDTO {
    @NotBlank
    @Size(max = 100, message = "O tamanho máximo do username é 100 caracteres.")
    private String username;
    private String avatar;
}
