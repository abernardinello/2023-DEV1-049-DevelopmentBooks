package com.bnpparibasfortis.developmentbooks.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.bnpparibasfortis.developmentbooks.model.Book;

@Service
public class ShoppingBasketServiceImpl implements ShoppingBasketService {
    @Override
    public Float computePrice(List<Book> shoppingBasket) {
        return CollectionUtils.isEmpty(shoppingBasket) ? 0f : null;
    }
}
