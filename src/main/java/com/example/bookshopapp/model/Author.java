package com.example.bookshopapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "authors")
@SQLDelete(sql = "UPDATE authors SET isDeleted = true WHERE id = ?")
@Where(clause = "isDeleted = false")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @Column(name = "year_of_birth")
    private Short yearOfBirth;
    private String biography;
    private boolean isDeleted;
}
