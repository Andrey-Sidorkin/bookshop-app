package com.example.bookshopapp.repository;

import com.example.bookshopapp.model.Book;
import com.example.bookshopapp.util.Genre;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, String> {
    List<Book> findByGenre(Genre genre);

    @Query("FROM Book b JOIN b.authors a WHERE a.id = :id")
    List<Book> findByAuthorId(Long id);

    @Query(value = "SELECT * FROM books WHERE UPPER (title) LIKE ("
            + "concat('%', UPPER(?1), '%'))", nativeQuery = true)
    List<Book> findByKeyword(String keyword);
}
