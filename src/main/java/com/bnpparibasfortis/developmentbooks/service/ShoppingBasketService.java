package com.bnpparibasfortis.developmentbooks.service;

import java.util.List;

import com.bnpparibasfortis.developmentbooks.model.Item;

public interface ShoppingBasketService {
    
    default Float computePrice(List<Item> shoppingBasket) {
        return null;
    }
}
