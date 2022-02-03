package com.example.bookshopapp.dto.mapper;

public interface Mapper<E, D, T> {
    D modelToDto(E entity);

    E dtoToModel(T dto);
}
