package com.example.bookshopapp.dto.mapper;

import com.example.bookshopapp.dto.request.AuthorRequestDto;
import com.example.bookshopapp.dto.response.AuthorResponseDto;
import com.example.bookshopapp.model.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class AuthorMapper implements
        GenericMapper<Author, AuthorResponseDto, AuthorRequestDto> {
}
