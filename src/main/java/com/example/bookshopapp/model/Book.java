package com.example.bookshopapp.model;

import com.example.bookshopapp.util.Genre;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "books")
public class Book {
    @Id
    private String isbn;
    private String title;
    @ManyToMany
    @JoinTable(name = "books_authors",
            joinColumns = @JoinColumn(name = "book_isbn"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authors;
    @Enumerated(value = EnumType.STRING)
    private Genre genre;
    private String description;
    @Column(name = "publishing_house")
    private String publishingHouse;
    @Column(name = "pages_number")
    private Integer pagesNumber;
}
