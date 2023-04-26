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
    public void givenShoppingBasketWith2DifferentBooks_whenComputePrice_thenReturnPriceWith5PercentDiscount() {
        Book book = new Book("Clean Code", "Robert Martin", "2008");
        Book book2 = new Book("The Clean Coder", "Robert Martin", "2011");
        SHOPPING_CART.add(book);
        SHOPPING_CART.add(book2);
        Float price = service.computePrice(SHOPPING_CART);
        Assertions.assertEquals((book.getPrice() + book2.getPrice()) * 0.95f, price);
    }

    @Test
    public void givenShoppingBasketWith3DifferentBooks_whenComputePrice_thenReturnPriceWith10PercentDiscount() {
        Book book = new Book("Clean Code", "Robert Martin", "2008");
        Book book2 = new Book("The Clean Coder", "Robert Martin", "2011");
        Book book3 = new Book("Clean Architecture", "Robert Martin", "2017");
        SHOPPING_CART.add(book);
        SHOPPING_CART.add(book2);
        SHOPPING_CART.add(book3);
        Float price = service.computePrice(SHOPPING_CART);
        Assertions.assertEquals((book.getPrice() + book2.getPrice() + book3.getPrice()) * 0.90f, price);
    }

    @Test
    public void givenShoppingBasketWith4DifferentBooks_whenComputePrice_thenReturnPriceWith20PercentDiscount() {
        Book book = new Book("Clean Code", "Robert Martin", "2008");
        Book book2 = new Book("The Clean Coder", "Robert Martin", "2011");
        Book book3 = new Book("Clean Architecture", "Robert Martin", "2017");
        Book book4 = new Book("Test Driven Development by Example", "Kent Beck", "2003");
        SHOPPING_CART.add(book);
        SHOPPING_CART.add(book2);
        SHOPPING_CART.add(book3);
        SHOPPING_CART.add(book4);
        Float price = service.computePrice(SHOPPING_CART);
        Assertions.assertEquals((book.getPrice() + book2.getPrice() + book3.getPrice() + book4.getPrice()) * 0.8f,
                price);
    }

    @Test
    public void givenShoppingBasketWith5DifferentBooks_whenComputePrice_thenReturnPriceWith25PercentDiscount() {
        Book book = new Book("Clean Code", "Robert Martin", "2008");
        Book book2 = new Book("The Clean Coder", "Robert Martin", "2011");
        Book book3 = new Book("Clean Architecture", "Robert Martin", "2017");
        Book book4 = new Book("Test Driven Development by Example", "Kent Beck", "2003");
        Book book5 = new Book("Working Effectively With Legacy Code", "Michael C. Feathers", "2004");
        SHOPPING_CART.add(book);
        SHOPPING_CART.add(book2);
        SHOPPING_CART.add(book3);
        SHOPPING_CART.add(book4);
        SHOPPING_CART.add(book5);
        Float price = service.computePrice(SHOPPING_CART);
        Assertions.assertEquals(
                (book.getPrice() + book2.getPrice() + book3.getPrice() + book4.getPrice() + book5.getPrice()) * 0.75f,
                price);
    }
}
