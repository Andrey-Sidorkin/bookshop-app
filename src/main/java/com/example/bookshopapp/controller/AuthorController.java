package com.example.bookshopapp.controller;

import com.example.bookshopapp.dto.mapper.AuthorMapper;
import com.example.bookshopapp.dto.request.AuthorRequestDto;
import com.example.bookshopapp.dto.response.AuthorResponseDto;
import com.example.bookshopapp.model.Author;
import com.example.bookshopapp.service.AuthorService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import javax.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/authors")
@Validated
public class AuthorController {
    private final AuthorService authorService;
    private final AuthorMapper mapper;

    @GetMapping("/{id}")
    public AuthorResponseDto get(@PathVariable @Positive Long id) {
        Author author = authorService.get(id);
        return mapper.modelToDto(author);
    }

    @GetMapping
    public List<AuthorResponseDto> getAll() {
        return authorService.getAll().stream()
                .map(mapper::modelToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public AuthorResponseDto save(@RequestBody @Valid AuthorRequestDto dto) {
        Author author = mapper.dtoToModel(dto);
        authorService.save(author);
        return mapper.modelToDto(author);
    }

    @PutMapping("/{id}")
    public AuthorResponseDto update(@PathVariable @Positive Long id,
                                    @RequestBody @Valid AuthorRequestDto dto) {
        Author author = mapper.dtoToModel(dto);
        author.setId(id);
        authorService.save(author);
        return mapper.modelToDto(author);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable @Positive Long id) {
        authorService.delete(id);
    }
}
