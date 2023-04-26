package com.bnpparibasfortis.developmentbooks.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.bnpparibasfortis.developmentbooks.model.Book;

@Service
public class ShoppingBasketServiceImpl implements ShoppingBasketService {
    @Override
    public Float computePrice(List<Book> shoppingBasket) {

        Float total = 0f;

        if (!CollectionUtils.isEmpty(shoppingBasket)) {

            total = shoppingBasket.stream().map(b -> b.getPrice()).reduce((b1, b2) -> b1 + b2).get();

            if (shoppingBasket.size() == 2) {
                total *= 0.95f;
            } else if(shoppingBasket.size() == 3) {
                total *= 0.9f;
            }

        }
        return total;
    }

}
