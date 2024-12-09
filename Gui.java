import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Gui extends JFrame {
    private static final long serialVersionUID = 1L;

    private ArrayList<Items> items; // List of available items
    private HashMap<Items, Integer> cart; // Shopping cart with item quantities

    public Gui() {
        setTitle("E-Commerce Platform");
        setSize(800, 600); // Smaller main window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize item list and cart
        items = new ArrayList<>();
        cart = new HashMap<>();

        // Add sample items (ensure Images/ folder matches)
        items.add(new Items("Apple", "A fresh red apple.", 1.5, "Images/apple.jpg"));
        items.add(new Items("Basketball", "An official Wilson basketball.", 20.0, "Images/basketball.jpg"));
        items.add(new Items("Bicycle", "A sturdy and stylish bicycle.", 120.0, "Images/bicycle.jpg"));
        items.add(new Items("Helmet", "A durable safety helmet.", 50.0, "Images/helmet.jpg"));
        items.add(new Items("Shoes", "Comfortable walking shoes.", 80.0, "Images/shoe.jpg"));

        // Create main product grid
        JPanel productGrid = new JPanel(new GridLayout(0, 3, 10, 10)); // Adjusted layout
        productGrid.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add products to grid
        for (Items item : items) {
            JPanel itemPanel = createProductPanel(item);
            productGrid.add(itemPanel);
        }

        // Add a "View Cart" button
        JButton viewCartButton = new JButton("View Cart");
        viewCartButton.setFont(new Font("Arial", Font.BOLD, 14));
        viewCartButton.addActionListener(e -> viewCart());

        // Add components to the frame
        add(new JScrollPane(productGrid), BorderLayout.CENTER);
        add(viewCartButton, BorderLayout.SOUTH);
    }

    // Create a product panel with image, name, and price
    private JPanel createProductPanel(Items item) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        // Resize the image dynamically
        ImageIcon originalIcon = new ImageIcon(item.getImagePath());
        Image scaledImage = originalIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Resize to 100x100
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(imageLabel, BorderLayout.CENTER);

        // Product name and price
        JLabel namePriceLabel = new JLabel(
                "<html><b>" + item.getName() + "</b><br>$" + item.getPrice() + "</html>",
                SwingConstants.CENTER);
        namePriceLabel.setFont(new Font("Arial", Font.PLAIN, 12)); // Smaller font for a smaller window
        panel.add(namePriceLabel, BorderLayout.NORTH);

        // View details button
        JButton detailsButton = new JButton("View Details");
        detailsButton.setFont(new Font("Arial", Font.PLAIN, 12));
        detailsButton.addActionListener(e -> viewProductDetails(item));
        panel.add(detailsButton, BorderLayout.SOUTH);

        return panel;
    }

    // Show detailed product information
    private void viewProductDetails(Items item) {
        JFrame detailsFrame = new JFrame(item.getName());
        detailsFrame.setSize(400, 300); // Smaller details window

        JPanel detailsPanel = new JPanel(new BorderLayout());
        detailsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Resize the image dynamically
        ImageIcon originalIcon = new ImageIcon(item.getImagePath());
        Image scaledImage = originalIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH); // Resize to 150x150
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        detailsPanel.add(imageLabel, BorderLayout.CENTER);

        // Product details
        JLabel detailsLabel = new JLabel(
                "<html><h2>" + item.getName() + "</h2><p>" + item.getDescription() + "</p><p><b>Price:</b> $" +
                        item.getPrice() + "</p></html>");
        detailsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        detailsPanel.add(detailsLabel, BorderLayout.NORTH);

        // Add to cart button
        JButton addToCartButton = new JButton("Add to Cart");
        addToCartButton.setFont(new Font("Arial", Font.PLAIN, 12));
        addToCartButton.addActionListener(e -> {
            cart.put(item, cart.getOrDefault(item, 0) + 1);
            JOptionPane.showMessageDialog(detailsFrame, item.getName() + " added to cart!");
        });
        detailsPanel.add(addToCartButton, BorderLayout.SOUTH);

        detailsFrame.add(detailsPanel);
        detailsFrame.setVisible(true);
    }

    // Show the shopping cart
    private void viewCart() {
        JFrame cartFrame = new JFrame("Shopping Cart");
        cartFrame.setSize(400, 300); // Smaller cart window

        JPanel cartPanel = new JPanel(new BorderLayout());
        JTextArea cartTextArea = new JTextArea();
        cartTextArea.setEditable(false);

        // Using an array to allow total to be mutable
        final double[] total = {0};
        StringBuilder cartContents = new StringBuilder();

        for (Items item : cart.keySet()) {
            int quantity = cart.get(item);
            total[0] += item.getPrice() * quantity;
            cartContents.append(item.getName())
                    .append(" - $")
                    .append(item.getPrice())
                    .append(" x ")
                    .append(quantity)
                    .append(" = $")
                    .append(String.format("%.2f", item.getPrice() * quantity))
                    .append("\n");
        }

        cartContents.append("\nTotal: $").append(String.format("%.2f", total[0]));
        cartTextArea.setText(cartContents.toString());

        // Checkout button
        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.addActionListener(e -> {
            if (cart.isEmpty()) {
                JOptionPane.showMessageDialog(cartFrame, "Your cart is empty!");
            } else {
                JOptionPane.showMessageDialog(cartFrame, "Thank you for your purchase! Total: $" + String.format("%.2f", total[0]));
                cart.clear();
                cartTextArea.setText(""); // Clear the cart display
                cartFrame.dispose();
            }
        });

        cartPanel.add(new JScrollPane(cartTextArea), BorderLayout.CENTER);
        cartPanel.add(checkoutButton, BorderLayout.SOUTH);

        cartFrame.add(cartPanel);
        cartFrame.setVisible(true);
    }
}
