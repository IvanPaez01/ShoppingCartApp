package main.java.model;

public class Product {
    private String name;
    private double price;
    private int quantity;

    private int seller_ID;

    public Product(String name, double price, int quantity, int seller) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.seller_ID = seller;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSeller_ID() {
        return seller_ID;
    }

    public void setSeller_ID(int ID) {
        this.seller_ID = ID;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", availableQuantity=" + quantity +
                ", seller_ID=" + seller_ID + '}';
    }
}
