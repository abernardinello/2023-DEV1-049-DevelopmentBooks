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
        Book book = getCleanCodeBook();
        SHOPPING_CART.add(book);
        Float price = service.computePrice(SHOPPING_CART);
        Assertions.assertEquals(book.getPrice(), price);
    }

    @Test
    public void givenShoppingBasketWith2DifferentBooks_whenComputePrice_thenReturnPriceWith5PercentDiscount() {
        Book book = getCleanCodeBook();
        Book book2 = getCleanCoderBook();
        SHOPPING_CART.add(book);
        SHOPPING_CART.add(book2);
        Float price = service.computePrice(SHOPPING_CART);
        Assertions.assertEquals((book.getPrice() + book2.getPrice()) * 0.95f, price);
    }

    @Test
    public void givenShoppingBasketWith3DifferentBooks_whenComputePrice_thenReturnPriceWith10PercentDiscount() {
        Book book = getCleanCodeBook();
        Book book2 = getCleanCoderBook();
        Book book3 = getCleanArchitectureBook();
        SHOPPING_CART.add(book);
        SHOPPING_CART.add(book2);
        SHOPPING_CART.add(book3);
        Float price = service.computePrice(SHOPPING_CART);
        Assertions.assertEquals((book.getPrice() + book2.getPrice() + book3.getPrice()) * 0.90f, price);
    }

    @Test
    public void givenShoppingBasketWith4DifferentBooks_whenComputePrice_thenReturnPriceWith20PercentDiscount() {
        Book book = getCleanCodeBook();
        Book book2 = getCleanCoderBook();
        Book book3 = getCleanArchitectureBook();
        Book book4 = getTDDByExcampleBook();
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
        Book book = getCleanCodeBook();
        Book book2 = getCleanCoderBook();
        Book book3 = getCleanArchitectureBook();
        Book book4 = getTDDByExcampleBook();
        Book book5 = getWorkingEffectivelyWithLegacyCodeBook();
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

    @Test
    public void givenShoppingBasketWithMoreThan1SameBooks_whenComputePrice_thenReturnPriceWithNoDiscount() {
        Book book = getCleanCodeBook();
        Book book2 = getCleanCodeBook();

        SHOPPING_CART.add(book);
        SHOPPING_CART.add(book2);

        Float price = service.computePrice(SHOPPING_CART);
        Assertions.assertEquals(book.getPrice() + book2.getPrice(), price);

    }

    @Test
    public void givenShoppingBasketWithDuplicateBooks_whenComputePrice_thenReturnPriceWithCorrectDiscount() {
        Book book = getCleanCodeBook();
        Book book2 = getCleanCodeBook();
        Book book3 = getCleanArchitectureBook();

        SHOPPING_CART.add(book);
        SHOPPING_CART.add(book2);
        SHOPPING_CART.add(book3);

        Float price = service.computePrice(SHOPPING_CART);
        Assertions.assertEquals(((book.getPrice() + book3.getPrice()) * 0.95f) + book2.getPrice(), price);

        SHOPPING_CART = new ArrayList<>();
        book = getCleanCodeBook();
        book2 = getCleanCodeBook();
        SHOPPING_CART.add(book);
        SHOPPING_CART.add(book2);
        Book book4 = getCleanCoderBook();
        Book book5 = getCleanCoderBook();

        Book book6 = getCleanArchitectureBook();
        Book book7 = getCleanArchitectureBook();

        Book book8 = getTDDByExcampleBook();
        Book book9 = getWorkingEffectivelyWithLegacyCodeBook();

        SHOPPING_CART.add(book4);
        SHOPPING_CART.add(book5);
        SHOPPING_CART.add(book6);
        SHOPPING_CART.add(book7);
        SHOPPING_CART.add(book8);
        SHOPPING_CART.add(book9);

        price = service.computePrice(SHOPPING_CART);
        Assertions.assertEquals(322.5f, price);
    }

    private Book getTDDByExcampleBook() {
        return new Book("Test Driven Development by Example", "Kent Beck", "2003");
    }

    private Book getCleanArchitectureBook() {
        return new Book("Clean Architecture", "Robert Martin", "2017");
    }

    private Book getCleanCoderBook() {
        return new Book("The Clean Coder", "Robert Martin", "2011");
    }

    private Book getCleanCodeBook() {
        return new Book("Clean Code", "Robert Martin", "2008");
    }

    private Book getWorkingEffectivelyWithLegacyCodeBook() {
        return new Book("Working Effectively With Legacy Code", "Michael C. Feathers", "2004");
    }
}
