package src.test.java.controller;

import model.Product;
import model.ShoppingCart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartControllerTest {
    private ShoppingCartController controller;
    private Product product;

    @BeforeEach
    void setUp() {
        controller = new ShoppingCartController();
        product = new Product("Test Product", 9.99, 10);
    }

    @Test
    void testAddProductToCart() {
        controller.addProductToCart(product);
        ShoppingCart cart = controller.getShoppingCart();
        assertTrue(cart.getProducts().contains(product));
    }

    @Test
    void testRemoveProductFromCart() {
        controller.addProductToCart(product);
        controller.removeProductFromCart(product);
        ShoppingCart cart = controller.getShoppingCart();
        assertFalse(cart.getProducts().contains(product));
    }

    @Test
    void testCalculateTotal() {
        controller.addProductToCart(product);
        assertEquals(9.99, controller.calculateTotal());
    }
}
