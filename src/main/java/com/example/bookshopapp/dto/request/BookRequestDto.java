package com.example.bookshopapp.dto.request;

import static com.example.bookshopapp.model.Book.ISBN_PATTERN;

import com.example.bookshopapp.lib.ValidGenre;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import lombok.Data;

@Data
public class BookRequestDto {
    @NotBlank
    @Pattern(regexp = ISBN_PATTERN, message = "'${validatedValue}' is not a valid ISBN")
    private String isbn;
    @NotBlank(message = "Title cannot be empty")
    private String title;
    @NotEmpty(message = "Author id list can't be empty")
    private List<Long> authorsIds;
    @ValidGenre
    private String genre;
    private String description;
    private String publishingHouse;
    @NotNull(message = "Number of pages should present")
    @Positive(message = "Number of pages should be positive")
    private Integer pagesNumber;
}
