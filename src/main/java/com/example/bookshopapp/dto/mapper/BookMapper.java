package com.example.bookshopapp.dto.mapper;

import com.example.bookshopapp.dto.request.BookRequestDto;
import com.example.bookshopapp.dto.response.BookResponseDto;
import com.example.bookshopapp.model.Author;
import com.example.bookshopapp.model.Book;
import com.example.bookshopapp.service.AuthorService;
import com.example.bookshopapp.util.Genre;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BookMapper implements Mapper<Book, BookResponseDto, BookRequestDto> {
    private final AuthorService authorService;

    @Override
    public BookResponseDto modelToDto(Book book) {
        BookResponseDto dto = new BookResponseDto();
        dto.setIsbn(book.getIsbn());
        dto.setTitle(book.getTitle());
        dto.setGenre(book.getGenre() != null ? book.getGenre().name() : null);
        dto.setDescription(book.getDescription());
        dto.setPagesNumber(book.getPagesNumber());
        dto.setPublishingHouse(book.getPublishingHouse());
        dto.setAuthorsIds(book.getAuthors().stream()
                .map(Author::getId)
                .collect(Collectors.toList()));
        return dto;
    }

    @Override
    public Book dtoToModel(BookRequestDto dto) {
        Book book = new Book();
        book.setIsbn(dto.getIsbn());
        book.setTitle(dto.getTitle());
        book.setGenre(Genre.valueOf(dto.getGenre()));
        book.setDescription(dto.getDescription());
        book.setPagesNumber(dto.getPagesNumber());
        book.setPublishingHouse(dto.getPublishingHouse());
        book.setAuthors(dto.getAuthorsIds().stream()
                .map(authorService::get)
                .collect(Collectors.toList()));
        return book;
    }
}
