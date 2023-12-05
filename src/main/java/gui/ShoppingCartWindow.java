import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ShoppingCartWindow extends JFrame {
    private JList<String> cartList;
    private DefaultListModel<String> cartModel;
    private JButton checkoutButton;

    public ShoppingCartWindow() {
        setTitle("Shopping Cart");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initUI();
    }

    private void initUI() {
        cartModel = new DefaultListModel<>();
        cartList = new JList<>(cartModel);
        JScrollPane scrollPane = new JScrollPane(cartList);

        checkoutButton = new JButton("Checkout");
        checkoutButton.addActionListener(e -> performCheckout());

        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(checkoutButton, BorderLayout.SOUTH);
    }

    private void performCheckout() {
        // Logic to proceed to checkout
        new CheckoutWindow().setVisible(true);
        this.dispose(); // Close the cart window
    }

    // Method to add items to the cart
    public void addItemToCart(String item) {
        cartModel.addElement(item);
    }

    // Main method for testing
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ShoppingCartWindow window = new ShoppingCartWindow();
            window.setVisible(true);
        });
    }
}
