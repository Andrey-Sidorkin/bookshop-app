package com.example.bookshopapp.dao;

import com.example.bookshopapp.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorDao extends JpaRepository<Author, Long> {
}
