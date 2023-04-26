package com.bnpparibasfortis.developmentbooks.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bnpparibasfortis.developmentbooks.model.Book;

public class ShoppingBasketServiceImplTest {

    private ShoppingBasketServiceImpl service = new ShoppingBasketServiceImpl();

    private List<Book> SHOPPING_CART;

    @BeforeEach
    public void initEach() {
        SHOPPING_CART = new ArrayList<>();
    }

    @Test
    public void givenEmtyShoppingCart_whenComputePrice_thenReturnZero() {
        Float price = service.computePrice(SHOPPING_CART);
        Assertions.assertEquals(0f, price);
    }
}
