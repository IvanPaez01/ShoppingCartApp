package src.main.java.controller;

import model.ShoppingCart; // Import statement for ShoppingCart
import model.Product; // Import statement for Product

public class ShoppingCartController {
    private ShoppingCart cart;

    public ShoppingCartController() {
        this.cart = new ShoppingCart();
    }

    public void addProductToCart(Product product) {
        cart.addProduct(product);
    }

    public void removeProductFromCart(Product product) {
        cart.removeProduct(product);
    }

    public double calculateTotal() {
        return cart.getTotalPrice();
    }

    public ShoppingCart getShoppingCart() {
        return cart;
    }

    // Additional methods for other functionalities
}
