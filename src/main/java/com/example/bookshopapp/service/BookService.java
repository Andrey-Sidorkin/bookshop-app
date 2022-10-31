package com.example.bookshopapp.service;

import com.example.bookshopapp.model.Book;
import java.util.List;

public interface BookService {
    Book get(String isbn);

    List<Book> getByGenre(Book.Genre genre);

    List<Book> getByKeyword(String keyword);

    List<Book> getByAuthorId(Long id);

    Book save(Book book);

    void delete(String isbn);
}
