package com.geekbrains.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductRepository repository = context.getBean("productRepository", ProductRepository.class);
        MsgLibrary library = context.getBean("msgLibrary", MsgLibrary.class);
        Cart cart = context.getBean("cart", Cart.class);

        Scanner scanner = new Scanner(System.in);
        String msg = scanner.nextLine();

        while (!msg.equals(library.CHECKOUT)) {

            if (!msg.startsWith("/")) {
                System.out.println("Wrong command");
                msg = scanner.nextLine();
                continue;
            }

            if (msg.equals(library.SHOW_ALL_PRODUCTS)) {
                System.out.println(repository.showAllProducts());
            } else if (msg.equals(library.SHOW_CART)) {
                System.out.println(cart.showCart());
            }

            if (msg.split(" ").length == 2) {
                try {
                    Long id = Long.parseLong(msg.split(" ")[1]);
                    Product product = repository.getProductById(id);
                    if (product == null) {
                        System.out.println("Product not found");
                    } else if (msg.startsWith(library.SHOW_PRODUCT_BY_ID)) {
                        System.out.println(repository.getProductById(id));
                    } else if (msg.startsWith(library.ADD_TO_CART)) {
                        cart.addToCart(product);
                    } else if (msg.startsWith(library.REMOVE_FROM_CART)) {
                        if (cart.removeFromCart(product)) {
                            System.out.println("Product removed");
                        } else {
                            System.out.println("Product not found in your cart");
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Wrong argument");
                }
            }

            msg = scanner.nextLine();
        }

        context.close();
    }
}
