package com.example.bookshopapp.service;

import com.example.bookshopapp.model.Author;
import java.util.List;

public interface AuthorService {
    Author get(Long id);

    List<Author> getAll();

    Author save(Author author);
    
    void delete(Long id);
}
