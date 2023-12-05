package src.test.java.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {
    private ShoppingCart cart;
    private Product product;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
        product = new Product("Test Product", 9.99, 10);
    }

    @Test
    void testAddProduct() {
        cart.addProduct(product);
        assertTrue(cart.getProducts().contains(product));
    }

    @Test
    void testRemoveProduct() {
        cart.addProduct(product);
        cart.removeProduct(product);
        assertFalse(cart.getProducts().contains(product));
    }

    @Test
    void testGetTotalPrice() {
        cart.addProduct(product);
        assertEquals(9.99, cart.getTotalPrice());
    }
}
