package com.bnpparibasfortis.developmentbooks.service;

import java.util.List;

import com.bnpparibasfortis.developmentbooks.model.Book;

public interface ShoppingBasketService {
    
    default Float computePrice(List<Book> shoppingBasket) {
        return null;
    }
}
