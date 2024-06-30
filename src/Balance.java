import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Balance extends Database{

    private int id;
    private double balance;

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    //update id = 1 in database
    public boolean update(int ID) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Shop_Balance SET balance = ? WHERE ID = ?");
            preparedStatement.setDouble(1, getBalance());
            preparedStatement.setInt(2, ID);
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;


        }
    }


    // get id = 1 from data base and return balance
    public double getInfoDB() {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM Shop_Balance WHERE ID = ?";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, 1);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        setId(resultSet.getInt("ID"));
                        setBalance(resultSet.getDouble("balance"));
                        return getBalance();
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error during search: " + e.getMessage());
            return 0;
        }

        return 0;

    }


}
