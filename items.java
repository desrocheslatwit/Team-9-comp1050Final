public class Items {


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

    // Getters
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

    // Setters
    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    public void setDescription(String description) {
        if (description != null && !description.isEmpty()) {
            this.description = description;
        }
    }

    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        }
    }

    public void setPrice(double price) {
        if (price >= 0.0) {
            this.price = price;
        }
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        }
    }

    @Override
    public String toString() {
        return String.format("Items{name='%s', description='%s', stock=%d, price=%.2f, quantity=%d}", 
                name, description, stock, price, quantity);
    }
}
