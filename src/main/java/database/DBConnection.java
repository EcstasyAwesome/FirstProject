package database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/lists?useSSL=false";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";
    private static Connection connection;

    public DBConnection() {
        try {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("-----------------------------");
            System.out.println("Не удалось загрузить драйвер.");
            System.out.println("-----------------------------");
        }
    }

    public Connection getConnection() {
        return connection;
    }

}
