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
    public void givenEmtyShoppingBasket_whenComputePrice_thenReturnZero() {
        Float price = service.computePrice(SHOPPING_CART);
        Assertions.assertEquals(0f, price);
    }

    @Test
    public void givenNullShoppingBasket_whenComputePrice_thenReturnZero() {
        Float price = service.computePrice(null);
        Assertions.assertEquals(0f, price);
    }

    @Test
    public void givenShoppingBasketWith1Book_whenComputePrice_thenReturnPriceOfTheBook() {
        Book book = new Book("Clean Code", "Robert Martin", "2008");
        SHOPPING_CART.add(book);
        Float price = service.computePrice(SHOPPING_CART);
        Assertions.assertEquals(book.getPrice(), price);
    }

    @Test
    public void givenShoppingBasketWith2DiferentBooks_whenComputePrice_thenReturnPriceWith5PercentDiscount() {
        Book book = new Book("Clean Code", "Robert Martin", "2008");
        Book book2 = new Book("The Clean Coder", "Robert Martin", "2011");
        SHOPPING_CART.add(book);
        SHOPPING_CART.add(book2);
        Float price = service.computePrice(SHOPPING_CART);
        Assertions.assertEquals((book.getPrice() + book.getPrice()) * 0.95f, price);
    }
}
