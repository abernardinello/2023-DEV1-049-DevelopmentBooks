package com.bnpparibasfortis.developmentbooks.model;

import lombok.Data;

@Data
public class Book {
    private final String title;
    private final String author;
    private final String year;
    private final Float price = 50f;
}
