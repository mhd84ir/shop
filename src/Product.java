public class Product {
    private String productName;
    private double price;
    private int stock;
    private String ID;

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getID() {
        return ID;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public String getProductName() {
        return productName;
    }
}
