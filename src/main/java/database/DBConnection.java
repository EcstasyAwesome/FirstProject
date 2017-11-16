package database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/lists?useSSL=false";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";
    private static DBConnection instance;
    private Connection connection;

    private DBConnection() {
        try {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            System.out.println("-> Соединение установлено");
        } catch (SQLException e) {
            System.out.println("-> Не удалось загрузить драйвер");
        }
    }

    public static DBConnection getInstance() {
        if (instance == null)
            return instance = new DBConnection();
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            connection.close();
            if (connection.isClosed()) {
                System.out.println("-> Соединение завершено");
            }
        } catch (SQLException e) {
            System.out.println("-> Не удалось завершить соединение");
        }
    }
}
