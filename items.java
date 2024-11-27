public class items {
    private String name = new String();
    private String description = new String();
    private int stock = 0;
    private double price = 0.00;
    private int quantity = 0;

    public items(String name, String description, int stock, double price, int quantity) {
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

    // TODO: Create 
    public String getFilePath() {
        return "";
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