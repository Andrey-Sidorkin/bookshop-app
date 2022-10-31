package com.example.bookshopapp.service.init;

import com.example.bookshopapp.model.Author;
import com.example.bookshopapp.model.Book;
import com.example.bookshopapp.service.AuthorService;
import com.example.bookshopapp.service.BookService;
import com.example.bookshopapp.util.Genre;
import java.util.List;
import javax.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InitData {
    private BookService bookService;
    private AuthorService authorService;

    @PostConstruct
    public void initialize() {
        Author proust = new Author();
        proust.setName("Marcel");
        proust.setSurname("Proust");
        proust.setBiography("Valentin Louis Georges Eugène Marcel Proust was a French novelist, "
                + "critic, and essayist who wrote the monumental novel In Search of Lost Time."
                + "He is considered by critics and writers to be one of the most influential "
                + "authors of the 20th century");
        proust.setYearOfBirth((short) 1871);

        Book proustBook1 = new Book();
        proustBook1.setTitle("The Prisoner");
        proustBook1.setIsbn("3-34563-445-6");
        proustBook1.setDescription("La Prisonnière (The Prisoner) picks up where Sodome et "
                + "Gomorrhe left off, with our narrator Marcel and his partner Albertine "
                + "now back in Paris, having left Balbec behind.");
        proustBook1.setPublishingHouse("Penguin Books");
        proustBook1.setGenre(Genre.FICTION);
        proustBook1.setAuthors(List.of(proust));
        proustBook1.setPagesNumber(254);

        Book proustBook2 = new Book();
        proustBook2.setTitle("In the Shadow of Young Girls in Flower");
        proustBook2.setIsbn("3-53846-487-6");
        proustBook2.setDescription("In the Shadow of Young Girls in Flower is Proust's "
                + "spectacular dissection of male and female adolescence, charged with "
                + "the narrator's memories of Paris and the Normandy seaside.");
        proustBook2.setPublishingHouse("Penguin Books");
        proustBook2.setGenre(Genre.FICTION);
        proustBook2.setAuthors(List.of(proust));
        proustBook2.setPagesNumber(227);

        authorService.save(proust);
        bookService.save(proustBook1);
        bookService.save(proustBook2);
    }
}
