package com.example.bookshopapp.model;

import static javax.persistence.EnumType.STRING;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
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
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "books")
@SQLDelete(sql = "UPDATE books SET isDeleted = true WHERE id = ?")
@Where(clause = "isDeleted = false")
public class Book {
    public static final String ISBN_PATTERN = "\\d-\\d{5}-\\d{3}-\\d";

    @Id
    private String isbn;
    private String title;
    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "books_authors",
            joinColumns = @JoinColumn(name = "book_isbn"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authors;
    @Enumerated(value = STRING)
    private Genre genre;
    private String description;
    @Column(name = "publishing_house")
    private String publishingHouse;
    @Column(name = "pages_number")
    private Integer pagesNumber;
    private boolean isDeleted;

    public enum Genre {
        FICTION,
        NATURAL_SCIENCE,
        HUMANITIES,
        PHILOSOPHY,
        POETRY,
        DRAMA,
        HISTORY
    }
}
