import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class Signin extends Database {

    private int ID;
    public boolean checkUsernameAndPassword (String username , String password)
    {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM User WHERE username = ?";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, username);

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String DBPassword = resultSet.getString("password");
                        if (password.equals(DBPassword)) {
                            try {
                                FileWriter writer = new FileWriter("data.txt");
                                int ID = resultSet.getInt("ID");
                                writer.write(ID + "," + DBPassword );
                                writer.close();
                                return true;
                            }
                            catch (IOException ee)
                            {
                                System.out.println("error");
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error during search: " + e.getMessage());
        }
        return false;
    }

//    public boolean checkPassword (String password)
//    {
//        //TODO
//        return true;
//    }
}
