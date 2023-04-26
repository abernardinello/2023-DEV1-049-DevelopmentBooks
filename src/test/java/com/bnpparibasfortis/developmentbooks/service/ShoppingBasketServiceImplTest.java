package com.bnpparibasfortis.developmentbooks.service;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bnpparibasfortis.developmentbooks.model.Book;

public class ShoppingBasketServiceImplTest {

    private ShoppingBasketServiceImpl service = new ShoppingBasketServiceImpl();

    @Test
    public void givenEmptyShoppingCart_whenAddBooks_thenReturnShoppingCartSize() {
        List<Book> shoppingCart = new ArrayList<>();

        List<Book> books = new ArrayList<>();

        Integer size = service.addBooks(books, shoppingCart);

        Assertions.assertThat(size.equals(0)).isTrue();
    }

}
