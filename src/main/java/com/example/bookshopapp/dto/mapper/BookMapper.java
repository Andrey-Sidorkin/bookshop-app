package com.example.bookshopapp.dto.mapper;

import com.example.bookshopapp.dto.request.BookRequestDto;
import com.example.bookshopapp.dto.response.BookResponseDto;
import com.example.bookshopapp.model.Author;
import com.example.bookshopapp.model.Book;
import com.example.bookshopapp.service.AuthorService;
import java.util.stream.Collectors;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", imports = {Author.class, Collectors.class})
@Setter
public abstract class BookMapper implements GenericMapper<Book, BookResponseDto, BookRequestDto> {
    @Autowired
    protected AuthorService authorService;

    @Override
    @Mapping(target = "authorsIds", expression = "java(book.getAuthors().stream()"
            + ".map(Author::getId).collect(Collectors.toList()))")
    public abstract BookResponseDto modelToDto(Book book);

    @Override
    @Mapping(target = "authors", expression = "java(dto.getAuthorsIds().stream()"
            + ".map(authorService::get).collect(Collectors.toList()))")
    public abstract Book dtoToModel(BookRequestDto dto);
}
