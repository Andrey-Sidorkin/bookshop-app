package com.example.bookshopapp.dto.request;

import com.example.bookshopapp.util.Genre;
import com.example.bookshopapp.util.IsbnPattern;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Data;

@Data
public class BookRequestDto {
    @NotBlank
    @Pattern(regexp = IsbnPattern.ISBN_PATTERN)
    private String isbn;
    @NotBlank
    private String title;
    @NotEmpty
    private List<Long> authorsIds;
    @NotBlank
    @Pattern(regexp = Genre.Pattern.GENRES_PATTERN)
    private String genre;
    private String description;
    private String publishingHouse;
    @NotNull
    private Integer pagesNumber;
}
