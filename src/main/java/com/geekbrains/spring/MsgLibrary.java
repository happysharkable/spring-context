package com.geekbrains.spring;

import org.springframework.stereotype.Component;

@Component
public class MsgLibrary {
    public final String CHECKOUT = "/checkout";
    public final String SHOW_ALL_PRODUCTS = "/show_all_products";
    public final String SHOW_PRODUCT_BY_ID = "/show_product";
    public final String SHOW_CART = "/show_cart";
    public final String ADD_TO_CART = "/add_to_cart";
    public final String REMOVE_FROM_CART = "/remove_from_cart";
}
