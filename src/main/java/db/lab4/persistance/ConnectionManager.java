package db.lab4.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    public static final String url = "jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    public static final String user = "root";
    public static final String password = "2029evgen";

    private static Connection connection = null;

    private ConnectionManager() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                System.out.println("SQLException: " + e.getMessage());
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("VendorError: " + e.getErrorCode());
            }
        }
        return connection;
    }
}


