import java.io.*;

public class Items implements Serializable {
    private String name = "";
    private String description = "";
    private int stock = 0;
    private double price = 0.00;
    private int quantity = 0;

    public Items(String name, String description, int stock, double price, int quantity) {
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.price = price;
        this.quantity = quantity;
        
    }

    // Methods to return different values to be used in the gui. 
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getStock() {
        return stock;
    }
    
    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Name cannot be null or empty.");
        }
    }

    public void setDescription(String description) {
        if (description != null && !description.isEmpty()) {
            this.description = description;
        } else {
            System.out.println("Description cannot be null or empty.");
        }
    }

    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        } else {
            System.out.println("Stock cannot be negative.");
        }
    }

    public void setPrice(double price) {
        if (price >= 0.0) {
            this.price = price;
        } else {
            System.out.println("Price cannot be negative.");
        }
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        } else {
            System.out.println("Quantity cannot be negative.");
        }
    }

     // Serialization Utility Methods
    public static void saveToFile(Items item, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(item);
            System.out.println("Object saved to file: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Items loadFromFile(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (Items) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return String.format("Items{name='%s', description='%s', stock=%d, price=%.2f, quantity=%d}", 
                name, description, stock, price, quantity);
    }
    

}

/*
 * TODO: Research how to click on an image. 
 * TODO: Methods: 
 *  getName
 *  getDescription
 *  getStock
 *  getPrice
 *  getQuantity
 *  getImage
 * 
 */