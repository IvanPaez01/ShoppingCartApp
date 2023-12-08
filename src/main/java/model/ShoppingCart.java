package main.java.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ivan Paez
 * The ShoppingCart class represents a shopping cart that holds a list of products.
 * It provides methods to add and remove products, calculate the total price, and retrieve the list of products.
 */
public class ShoppingCart {

    // List of products in the shopping cart
    private List<Product> products;

    /**
     * Constructs a ShoppingCart object with an empty list of products.
     */
    public ShoppingCart() {
        products = new ArrayList<>();
    }

    /**
     * Adds a product to the shopping cart.
     *
     * @param product The product to be added to the cart
     */
    public void addProduct(Product product) {
        products.add(product);
    }

    /**
     * Removes a product from the shopping cart.
     *
     * @param product The product to be removed from the cart
     */
    public void removeProduct(Product product) {
        products.remove(product);
    }

    /**
     * Calculates the total price of all products in the shopping cart.
     *
     * @return The total price of all products in the cart
     */
    public double getTotalPrice() {
        double total = 0.0;
        for (Product product : products) {
            total += product.getPrice() * product.getQuantity();
        }
        return total;
    }

    /**
     * Gets the list of products in the shopping cart.
     *
     * @return The list of products in the cart
     */
    public List<Product> getProducts() {
        return products;
    }

    // Other necessary methods like update quantity, clear cart, etc.
}
