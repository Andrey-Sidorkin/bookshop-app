package com.example.bookshopapp.service.impl;

import com.example.bookshopapp.repository.BookRepository;
import com.example.bookshopapp.model.Book;
import com.example.bookshopapp.service.BookService;
import com.example.bookshopapp.util.Genre;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public Book get(String isbn) {
        return bookRepository.findById(isbn)
                .orElseThrow(() -> new RuntimeException("Unable to fetch book with isbn " + isbn));
    }

    @Override
    public List<Book> getByGenre(Genre genre) {
        return bookRepository.findByGenre(genre);
    }

    @Override
    public List<Book> getByKeyword(String keyword) {
        return bookRepository.findByKeyword(keyword);
    }

    @Override
    public List<Book> getByAuthorId(Long id) {
        return bookRepository.findByAuthorId(id);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void delete(String isbn) {
        bookRepository.deleteById(isbn);
    }
}
