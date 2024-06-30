import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Product extends Database {

    private int ID;
    private String productName;
    private double price;
    private int stock;

    private File picture;

    private ImageIcon imageIcon;


    private ArrayList<Product> products = new ArrayList<Product>();


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

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
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

    public ArrayList<Product> getProducts() {
        return products;
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

    public boolean getInfoDB(int ID) {
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
                                InputStream imageStream = new ByteArrayInputStream(baos.toByteArray());
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


    // get all product from database and add to products
    public ArrayList<Product> getAllProductFromDB() {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM Product";

            try (PreparedStatement statement = connection.prepareStatement(query)) {

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Product product = new Product();
                        product.setID(resultSet.getInt("ID"));
                        product.setProductName(resultSet.getString("productName"));
                        product.setPrice(resultSet.getDouble("price"));
                        product.setStock(resultSet.getInt("stock"));
                        byte[] imageBytes = resultSet.getBytes("photo");
                        if (imageBytes != null) {
                            try {

                                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                                baos.write(imageBytes);
                                baos.flush();
                                InputStream imageStream = new ByteArrayInputStream(baos.toByteArray());
                                product.setImageIcon(new ImageIcon(imageBytes));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            System.out.println("Image not found in database.");
                        }
                        products.add(product);
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error during search: " + e.getMessage());
        }

        return products;
    }


    public boolean search(String name) {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM Product WHERE productName = ?";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, name);

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
                                InputStream imageStream = new ByteArrayInputStream(baos.toByteArray());
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

    // get a array of Id and return a arraylist of products
    public ArrayList<Product> getProductsByIds(ArrayList<Integer> ids) {
        ArrayList<Product> products = new ArrayList<>();
        for (int id : ids) {
            Product product = new Product();
            if (product.getInfoDB(id)) {
                products.add(product);
            }
        }
        return products;
    }

    // update data base by getter method
    public boolean updateProduct(int ID) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Product SET productName = ?, price = ?, stock = ? WHERE ID = ?");
            preparedStatement.setString(1, getProductName());
            preparedStatement.setDouble(2, getPrice());
            preparedStatement.setInt(3, getStock());
            preparedStatement.setInt(4, ID);
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;


        }
    }
}
