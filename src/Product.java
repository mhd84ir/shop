import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Product extends Database {

    private int ID;
    private String productName;
    private double price;
    private int stock;

    private File picture ;

    private ImageIcon imageIcon;


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

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
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

    public ImageIcon getImageIcon() {
        return imageIcon;
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

    public boolean getInfoDB(int ID)
    {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM Product WHERE ID = ?";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, ID);

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {

                        setID(resultSet.getInt("ID"));
                        setProductName(resultSet.getString("productName"));
                        setPrice(resultSet.getDouble("price"));
                        setStock(resultSet.getInt("stock"));
                        byte[] imageBytes = resultSet.getBytes("photo");
                        if (imageBytes != null) {
                            try {

                                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                                    baos.write(imageBytes);
                                    baos.flush();
                                InputStream imageStream =  new ByteArrayInputStream(baos.toByteArray());
                                imageIcon = new ImageIcon(imageBytes);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            System.out.println("Image not found in database.");
                        }




                        return true;


                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error during search: " + e.getMessage());
        }

        return false;
    }




}
