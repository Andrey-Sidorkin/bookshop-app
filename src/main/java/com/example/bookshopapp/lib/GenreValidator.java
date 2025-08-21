package com.example.bookshopapp.lib;

import static com.example.bookshopapp.model.Book.Genre;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GenreValidator implements ConstraintValidator<ValidGenre, String> {
    private static final Pattern GENRES_PATTERN;

    static {
        GENRES_PATTERN = Pattern.compile("(?si)"
                + Arrays.stream(Genre.values())
                .map(Enum::toString)
                .collect(Collectors.joining("|")));
    }

    @Override
    public boolean isValid(String genre, ConstraintValidatorContext constraintValidatorContext) {
        return GENRES_PATTERN.matcher(genre).matches();
    }
}
