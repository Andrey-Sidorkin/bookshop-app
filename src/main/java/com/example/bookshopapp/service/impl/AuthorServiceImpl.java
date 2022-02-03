package com.example.bookshopapp.service.impl;

import com.example.bookshopapp.dao.AuthorDao;
import com.example.bookshopapp.model.Author;
import com.example.bookshopapp.service.AuthorService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorDao authorDao;

    @Override
    public Author get(Long id) {
        return authorDao.findById(id).orElse(null);
    }

    @Override
    public List<Author> getAll() {
        return authorDao.findAll();
    }

    @Override
    public Author save(Author author) {
        return authorDao.save(author);
    }

    @Override
    public void delete(Long id) {
        authorDao.deleteById(id);
    }
}
