package com.bnpparibasfortis.developmentbooks.model;

import lombok.Data;

@Data
public class Book extends Item {
    private final String title;
    private final String author;
    private final String year;

    public Book(String title, String author, String year, Float price) {
        super(price);
        this.title = title;
        this.author = author;
        this.year = year;
    }
}
