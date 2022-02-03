package com.example.bookshopapp.service.impl;

import com.example.bookshopapp.repository.AuthorRepository;
import com.example.bookshopapp.model.Author;
import com.example.bookshopapp.service.AuthorService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Override
    public Author get(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Unable to fetch author with id " + id));
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }
}
