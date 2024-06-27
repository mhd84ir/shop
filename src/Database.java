import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private final String url = "jdbc:mysql://matterhorn.liara.cloud:33009/Shop";
    private final String username = "root";
    private final String password = "hMoOWj4JZDUVn34F1PP5LhkW";

    // متد برای برقراری اتصال به دیتابیس
    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
