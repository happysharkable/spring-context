package com.geekbrains.spring;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    private void init() {
        products = new ArrayList<>();
        products.addAll(Arrays.asList(
                new Product(1L,"Алгоритмы Java", 2000),
                new Product(2L,"Грокаем алгоритмы", 1000),
                new Product(3L,"Философия Java", 1500),
                new Product(4L,"Совершенный код", 1500),
                new Product(5L,"50 оттенков серого", 100)
        ));
    }

    public List<Product> showAllProducts() {
        return Collections.unmodifiableList(products);
    }

    public Product getProductById(Long id) {
        for (Product p : products) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }
}
