import java.io.Serializable;

public class Items implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String description;
    private double price;
    private String imagePath;

    public Items(String name, String description, double price, String imagePath) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getImagePath() {
        return imagePath;
    }

    @Override
    public String toString() {
        return String.format("%s - $%.2f\n%s", name, price, description);
    }
}
