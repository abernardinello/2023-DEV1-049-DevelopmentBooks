package com.bnpparibasfortis.developmentbooks.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.bnpparibasfortis.developmentbooks.model.Book;
import com.bnpparibasfortis.developmentbooks.model.Item;

@Service
public class ShoppingBasketServiceImpl implements ShoppingBasketService {
    @Override
    public Float computePrice(List<Item> shoppingBasket) {

        Float total = 0f;

        while (!CollectionUtils.isEmpty(shoppingBasket)) {
            Float subTotal = 0f;
            Set<Item> subBasket = new HashSet<>();
            shoppingBasket = shoppingBasket.stream().filter(n -> !subBasket.add(n)).collect(Collectors.toList());

            subTotal = subBasket.stream().map(b -> b.getPrice()).reduce((b1, b2) -> b1 + b2).get();

            if (subBasket.size() == 2) {
                subTotal *= 0.95f;
            } else if (subBasket.size() == 3) {
                subTotal *= 0.9f;
            } else if (subBasket.size() == 4) {
                subTotal *= 0.8f;
            } else if (subBasket.size() == 5) {
                subTotal *= 0.75f;
            }
            total += subTotal;
        }

        return total;
    }

}
