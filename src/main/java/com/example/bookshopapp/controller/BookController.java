package com.example.bookshopapp.controller;

import com.example.bookshopapp.dto.mapper.BookMapper;
import com.example.bookshopapp.dto.request.BookRequestDto;
import com.example.bookshopapp.dto.response.BookResponseDto;
import com.example.bookshopapp.model.Book;
import com.example.bookshopapp.service.BookService;
import com.example.bookshopapp.util.Genre;
import com.example.bookshopapp.util.IsbnPattern;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/books")
@Validated
public class BookController {
    private final BookService bookService;
    private final BookMapper mapper;

    @GetMapping("/{isbn}")
    public BookResponseDto get(@PathVariable @Pattern(
            regexp = IsbnPattern.ISBN_PATTERN) String isbn) {
        Book book = bookService.get(isbn);
        return mapper.modelToDto(book);
    }

    @GetMapping("/by-genre")
    public List<BookResponseDto> getByGenre(@RequestParam(name = "name") @Pattern(
            regexp = Genre.Pattern.GENRES_PATTERN) String genre) {
        return bookService.getByGenre(Genre.valueOf(genre.toUpperCase()))
                .stream()
                .map(mapper::modelToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/by-author")
    public List<BookResponseDto> getByAuthorId(
            @RequestParam(name = "id") @Positive Long id) {
        return bookService.getByAuthorId(id)
                .stream()
                .map(mapper::modelToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/by-keyword")
    public List<BookResponseDto> getByKeyword(
            @RequestParam(name = "key") @NotBlank String keyword) {
        return bookService.getByKeyword(keyword)
                .stream()
                .map(mapper::modelToDto)
                .collect(Collectors.toList());
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public BookResponseDto save(@RequestBody @Valid BookRequestDto dto) {
        Book book = mapper.dtoToModel(dto);
        bookService.save(book);
        return mapper.modelToDto(book);
    }

    @DeleteMapping("/{isbn}")
    public void delete(@PathVariable String isbn) {
        bookService.delete(isbn);
    }
}
