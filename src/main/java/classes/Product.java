package classes;

public class Product {
    private int id;
    private String name;
    private double price;
    private String photo;

    public Product() {
    }

    public Product(int id, String name, String photo, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
