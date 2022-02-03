package com.example.bookshopapp.dto.mapper;

import com.example.bookshopapp.dto.request.AuthorRequestDto;
import com.example.bookshopapp.dto.response.AuthorResponseDto;
import com.example.bookshopapp.model.Author;
import com.example.bookshopapp.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AuthorMapper implements Mapper<Author, AuthorResponseDto, AuthorRequestDto> {
    private final BookService bookService;

    @Override
    public AuthorResponseDto modelToDto(Author author) {
        AuthorResponseDto dto = new AuthorResponseDto();
        dto.setId(author.getId());
        dto.setName(author.getName());
        dto.setSurname(author.getSurname());
        dto.setBiography(author.getBiography());
        dto.setYearOfBirth(author.getYearOfBirth());
        return dto;
    }

    @Override
    public Author dtoToModel(AuthorRequestDto dto) {
        Author author = new Author();
        author.setName(dto.getName());
        author.setSurname(dto.getSurname());
        author.setBiography(dto.getBiography());
        author.setYearOfBirth(dto.getYearOfBirth());
        return author;
    }
}
