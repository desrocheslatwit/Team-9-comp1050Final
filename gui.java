import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame {
    private static final long serialVersionUID = 1L;

    // GUI components
    private JTextField nameField;
    private JTextField descriptionField;
    private JTextField stockField;
    private JTextField priceField;
    private JTextField quantityField;
    private JTextArea outputArea;

    // Current `Items` instance
    private Items currentItem;

    public Gui() {
        // Configure the JFrame
        setTitle("Items Management");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input panel for item details
        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Description:"));
        descriptionField = new JTextField();
        inputPanel.add(descriptionField);

        inputPanel.add(new JLabel("Stock:"));
        stockField = new JTextField();
        inputPanel.add(stockField);

        inputPanel.add(new JLabel("Price:"));
        priceField = new JTextField();
        inputPanel.add(priceField);

        inputPanel.add(new JLabel("Quantity:"));
        quantityField = new JTextField();
        inputPanel.add(quantityField);

        add(inputPanel, BorderLayout.NORTH);

        // Output area for messages or item details
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // Button panel for actions
        JPanel buttonPanel = new JPanel();
        JButton saveButton = new JButton("Save Item");
        JButton showButton = new JButton("Show Item");
        buttonPanel.add(saveButton);
        buttonPanel.add(showButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Button actions
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveItem();
            }
        });

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showItem();
            }
        });
    }

    // Save the current item from the input fields
    private void saveItem() {
        try {
            String name = nameField.getText();
            String description = descriptionField.getText();
            int stock = Integer.parseInt(stockField.getText());
            double price = Double.parseDouble(priceField.getText());
            int quantity = Integer.parseInt(quantityField.getText());

            // Update or create the current item
            if (currentItem == null) {
                currentItem = new Items(name, description, stock, price, quantity);
            } else {
                currentItem.setName(name);
                currentItem.setDescription(description);
                currentItem.setStock(stock);
                currentItem.setPrice(price);
                currentItem.setQuantity(quantity);
            }

            outputArea.setText("Item saved successfully:\n" + currentItem.toString());
        } catch (NumberFormatException e) {
            outputArea.setText("Invalid input. Please check your entries.");
        }
    }

    // Here we display the current item's details
    private void showItem() {
        if (currentItem != null) {
            outputArea.setText(currentItem.toString());
        } else {
            outputArea.setText("No item to display. Save an item first.");
        }
    }
}
