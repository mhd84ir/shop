import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Product extends Database {

    private int ID;
    private String productName;
    private double price;
    private int stock;

    private File picture;


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

    public void setPicture(File picture) {
        this.picture = picture;
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

    public File getPicture() {
        return picture;
    }

    public boolean addProductToDB() {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Product (productName, price, stock, photo) VALUES (?,?,?,?)");
            preparedStatement.setString(1, getProductName());
            preparedStatement.setDouble(2, getPrice());
            preparedStatement.setInt(3, getStock());
            FileInputStream fis = new FileInputStream(getPicture());
            preparedStatement.setBlob(4, fis);
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }
}
