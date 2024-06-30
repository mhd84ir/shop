import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.Base64;


public class SignUp extends Database {
    private String userName;
    private String password;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    private boolean isINDatabase(String userName)
    {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            statement = connection.createStatement();
            String query = "SELECT * FROM User";
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String DBUser = resultSet.getString("userName");
                if (DBUser.equals(userName))
                {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;

    }


    private boolean isValidUsername(String username) {
        // Username should be between 3 and 20 characters
        if (username.length() < 3 || username.length() > 20) {
            return false;
        }

        // Username should only contain alphanumeric characters and underscore
        if (!username.matches("^[a-zA-Z0-9_]*$")) {
            return false;
        }

        if (isINDatabase(username))
        {
            return false;
        }

        return true;
    }

    public boolean isValidPassword(String password) {
        // Password should be at least 8 characters long
        if (password.length() < 4) {
            return false;
        }

        // Password should contain at least one uppercase letter
        if (!password.matches("^[a-zA-Z0-9_]*$")) {
            return false;
        }


        return true;
    }


    public boolean addToDB (String userName , String password)
    {
        if (isValidPassword(password) && isValidUsername(userName))
        {
            try (Connection connection = getConnection()) {

            String query = "INSERT INTO User (password, userName, role) VALUES (?, ?, ?)";


            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, HashPassword(password));
                statement.setString(2, userName);
                statement.setString(3, "normal");

                int rowsInserted = statement.executeUpdate();

                return rowsInserted > 0;
            }
        } catch (SQLException e) {
        System.err.println("Error during signup: " + e.getMessage());
        return false;
            }
        }

        return false;
    }

    public static String HashPassword (String password)
    {
        String hashedPassword;
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e)
        {
            throw new RuntimeException(e);
        }

        hashedPassword = Base64.getEncoder().encodeToString(messageDigest.digest(password.getBytes()));
        return hashedPassword;
    }



}
