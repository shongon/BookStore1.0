package Execute;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/bookstore";
    private static final String USER = "root";
    private static final String PASSWORD = "16102004@";
    private static boolean isConnected = false;

    public static Connection connect() {
        Connection connection = null;
        try {
            if (!isConnected || connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                if (!isConnected) { // Print message only once
                    System.out.println("Connected to the MySQL server successfully.");
                    isConnected = true; // Update status
                }
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while connecting MySQL database.");
            e.printStackTrace();
        }
        return connection;
    }

    public static void disconnect(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Disconnected from the MySQL server successfully.");
                isConnected = false; // Update status on disconnect
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while disconnecting MySQL database.");
            e.printStackTrace();
        }
    }
}
