package com.geekbrains.spring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {
    private List<Product> cart;

    @PostConstruct
    private void init() {
        cart = new ArrayList<>();
    }

    public List<Product> showCart() {
        return Collections.unmodifiableList(cart);
    }

    public void addToCart(Product product) {
        cart.add(product);
    }

    public boolean removeFromCart(Product product) {
        if (!cart.contains(product)) {
            return false;
        }

        cart.remove(product);
        return true;
    }
}
