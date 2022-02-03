package com.example.bookshopapp.dto.request;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthorRequestDto {
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    private Short yearOfBirth;
    private String biography;
}
