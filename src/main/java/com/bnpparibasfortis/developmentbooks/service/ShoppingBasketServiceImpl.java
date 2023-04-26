package com.bnpparibasfortis.developmentbooks.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bnpparibasfortis.developmentbooks.model.Book;

@Service
public class ShoppingBasketServiceImpl implements ShoppingBasketService {
    @Override
    public Float computePrice(List<Book> shoppingBasket) {
        return shoppingBasket.isEmpty() ? 0f : null;
    }
}
