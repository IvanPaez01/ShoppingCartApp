package main.java.model;

import java.io.Serializable;

/**
 * @author Justin Knight
 * The Product class represents a product with its name, price, quantity, and seller information.
 * It implements the Serializable interface to support object serialization.
 */
public class Product implements Serializable {

    // Product attributes
    private String name;
    private double price;
    private int quantity;
    private String seller_ID;

    /**
     * Constructs a Product object with the specified name, price, quantity, and seller ID.
     *
     * @param name     The name of the product
     * @param price    The price of the product
     * @param quantity The initial quantity of the product
     * @param seller   The ID of the seller associated with the product
     */
    public Product(String name, double price, int quantity, String seller) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.seller_ID = seller;
    }

    /**
     * Gets the name of the product.
     *
     * @return The name of the product
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the product.
     *
     * @param name The new name of the product
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the price of the product.
     *
     * @return The price of the product
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the product.
     *
     * @param price The new price of the product
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the available quantity of the product.
     *
     * @return The available quantity of the product
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the available quantity of the product.
     *
     * @param quantity The new available quantity of the product
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the ID of the seller associated with the product.
     *
     * @return The ID of the seller
     */
    public String getSeller_ID() {
        return seller_ID;
    }

    /**
     * Sets the ID of the seller associated with the product.
     *
     * @param ID The new ID of the seller
     */
    public void setSeller_ID(String ID) {
        this.seller_ID = ID;
    }

    /**
     * Overrides the toString method to provide a string representation of the Product object.
     *
     * @return A string representation of the Product object
     */
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", availableQuantity=" + quantity +
                ", seller_ID=" + seller_ID + '}';
    }
}
