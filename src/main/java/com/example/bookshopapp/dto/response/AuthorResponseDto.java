package com.example.bookshopapp.dto.response;

import lombok.Data;

@Data
public class AuthorResponseDto {
    private Long id;
    private String name;
    private String surname;
    private Short yearOfBirth;
    private String biography;
}
