package com.github.firstproject.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnection {

    private static final DataSource dataSource;

    static {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            dataSource = (DataSource) envContext.lookup("jdbc/mydb");
            Connection connection = dataSource.getConnection();
            if (connection != null) connection.close();
            Info.print(DBConnection.class, "Пул соединений работает нормально");
        } catch (Exception e) {
            throw new ExceptionInInitializerError();
        }
    }

    private DBConnection() {
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}