package com.example.bookshopapp.dto.response;

import java.util.List;
import lombok.Data;

@Data
public class BookResponseDto {
    private String isbn;
    private String title;
    private List<Long> authorsIds;
    private String genre;
    private String description;
    private String publishingHouse;
    private Integer pagesNumber;
}
