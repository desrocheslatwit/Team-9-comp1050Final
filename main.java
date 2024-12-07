import java.io.*;
import java.util.*;
import javax.swing.SwingUtilities;


public class main {


public class ItemLoader {

    public static List<items> loadItemsFromFile(String fileName) {
        List<items> itemList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String name = parts[0].trim();
                    String description = parts[1].trim();
                    int stock = Integer.parseInt(parts[2].trim());
                    double price = Double.parseDouble(parts[3].trim());
                    int quantityBought = Integer.parseInt(parts[4].trim());

                    items item = new items(name, description, stock, price, quantityBought);
                    itemList.add(item);
                } else {
                    System.err.println("Invalid line format: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing number: " + e.getMessage());
        }

        return itemList;
    }
}


    public static void main(String[] args) {
        // Launch the GUI application in the Swing event-dispatching thread
        SwingUtilities.invokeLater(() -> {
            gui gui = new gui(); // Create the GUI instance
            gui.setVisible(true); // Make the GUI visible
            
            
            // Example for loading items: 
            // List<items> loadedItems = ItemLoader.loadItemsFromFile("test.txt");
            // for (items item : loadedItems) {
            //     System.out.println("Name: " + item.getName());
            // }
        });
    }
}
