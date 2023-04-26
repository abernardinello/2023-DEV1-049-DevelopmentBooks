package com.bnpparibasfortis.developmentbooks.service;

import java.util.List;

import com.bnpparibasfortis.developmentbooks.model.Book;

public interface ShoppingBasketService {
    default Integer addBooks(List<Book> booksToAdd, List<Book> shoppingBasket) {
        return null;
    }
    
    default Float computePrice(List<Book> shoppingBasket) {
        return null;
    }
}
