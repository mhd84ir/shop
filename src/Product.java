public class Product {

    private int ID;
    private String productName;
    private double price;
    private int stock;


    public void setID(int ID) {
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

    public int getID() {
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
