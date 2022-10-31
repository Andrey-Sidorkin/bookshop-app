package com.example.bookshopapp.dto.request;

import static com.example.bookshopapp.model.Book.ISBN_PATTERN;

import com.example.bookshopapp.lib.ValidGenre;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Data;

@Data
public class BookRequestDto {
    @NotBlank
    @Pattern(regexp = ISBN_PATTERN, message = "ISBN is not valid")
    private String isbn;
    @NotBlank
    private String title;
    @NotEmpty
    private List<Long> authorsIds;
    @ValidGenre
    private String genre;
    private String description;
    private String publishingHouse;
    @NotNull
    private Integer pagesNumber;
}
