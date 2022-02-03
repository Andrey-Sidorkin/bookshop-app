package com.example.bookshopapp.service.impl;

import com.example.bookshopapp.dao.BookDao;
import com.example.bookshopapp.model.Book;
import com.example.bookshopapp.service.BookService;
import com.example.bookshopapp.util.Genre;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookDao bookDao;

    @Override
    public Book get(String isbn) {
        return bookDao.findById(isbn).orElse(null);
    }

    @Override
    public List<Book> getByGenre(Genre genre) {
        return bookDao.findByGenre(genre);
    }

    @Override
    public List<Book> getByKeyword(String keyword) {
        return bookDao.findByKeyword(keyword);
    }

    @Override
    public List<Book> getByAuthorId(Long id) {
        return bookDao.findByAuthorId(id);
    }

    @Override
    public Book save(Book book) {
        return bookDao.save(book);
    }

    @Override
    public void delete(String isbn) {
        bookDao.deleteById(isbn);
    }
}
