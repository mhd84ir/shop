import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class User extends Database {
    private int ID;
    private String name ;
    private String address ;
    private String phoneNumber ;
    private String Email ;
    private String password ;
    private double credit ;
    private String userName ;
    //role: to know whether user is an admin or not
    private String role ;

    private ArrayList <User> users = new ArrayList<User>();

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return password;
    }

    public double getCredit() {
        return credit;
    }

    public String getUserName() {
        return userName;
    }

    public String getRole() {
        return role;
    }

    public void addCredit(double creditAdded){
        double newCredit = getCredit() + creditAdded;
        setCredit(newCredit);
    }

    public boolean changePassword (String oldPassword , String newPassword)
    {

        if (oldPassword.equals(getPassword()) && !oldPassword.equals(newPassword) && new SignUp().isValidPassword(newPassword))
        {
            setPassword(newPassword);
            if (editProfile())
            {
                return true;
            }
        }

        return false;
    }


    public boolean getInfoDB(int ID , String password)
    {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM User WHERE ID = ?";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, ID);

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String DBPassword = resultSet.getString("password");
                        if (password.equals(DBPassword)) {

                            setID(resultSet.getInt("ID"));
                            setName(resultSet.getString("name"));
                            setAddress(resultSet.getString("address"));
                            setPhoneNumber(resultSet.getString("phoneNumber"));
                            setEmail(resultSet.getString("Email"));
                            setPassword(resultSet.getString("password"));
                            setCredit(resultSet.getDouble("credit"));
                            setUserName(resultSet.getString("userName"));
                            setRole(resultSet.getString("role"));

                            return true;

                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error during search: " + e.getMessage());
        }

        return false;
    }


    public boolean editProfile ()

    {
        try (Connection connection = getConnection()) {
            String query = "UPDATE User SET name = ? , address = ? , phoneNumber = ? , Email = ? , credit = ? , role = ? , password = ? WHERE ID = ?";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, getName());
                statement.setString(2, getAddress());
                statement.setString(3, getPhoneNumber());
                statement.setString(4, getEmail());
                statement.setDouble(5, getCredit());
                statement.setString(6, getRole());
                statement.setString(7, getPassword());
                statement.setInt(8, getID());

                statement.executeUpdate();
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error during search: " + e.getMessage());
        }

        return false;
    }


    //get all users from database
    public ArrayList<User> getAllUsers()
    {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM User";

            try (PreparedStatement statement = connection.prepareStatement(query)) {

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        User user = new User();
                        user.setID(resultSet.getInt("ID"));
                        user.setName(resultSet.getString("name"));
                        user.setAddress(resultSet.getString("address"));
                        user.setPhoneNumber(resultSet.getString("phoneNumber"));
                        user.setEmail(resultSet.getString("Email"));
                        user.setPassword(resultSet.getString("password"));
                        user.setCredit(resultSet.getDouble("credit"));
                        user.setUserName(resultSet.getString("userName"));
                        user.setRole(resultSet.getString("role"));

                        users.add(user);
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error during search: " + e.getMessage());
        }

        return users;
    }


}
