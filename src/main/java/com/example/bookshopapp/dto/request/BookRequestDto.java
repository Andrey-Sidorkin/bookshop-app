package com.example.bookshopapp.dto.request;

import static com.example.bookshopapp.model.Book.BookPattern.GENRES_PATTERN;
import static com.example.bookshopapp.model.Book.BookPattern.ISBN_PATTERN;

import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Data;

@Data
public class BookRequestDto {
    @NotBlank
    @Pattern(regexp = ISBN_PATTERN)
    private String isbn;
    @NotBlank
    private String title;
    @NotEmpty
    private List<Long> authorsIds;
    @NotBlank
    @Pattern(regexp = GENRES_PATTERN)
    private String genre;
    private String description;
    private String publishingHouse;
    @NotNull
    private Integer pagesNumber;
}
