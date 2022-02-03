package com.example.bookshopapp.util;

public enum Genre {
    FICTION,
    NATURAL_SCIENCE,
    HUMANITIES,
    PHILOSOPHY,
    POETRY,
    DRAMA,
    HISTORY;

    public static class Pattern {
        public static final String GENRES_PATTERN =
                "FICTION|NATURAL_SCIENCE|HUMANITIES|"
                        + "PHILOSOPHY|POETRY|DRAMA|HISTORY";
    }
}
