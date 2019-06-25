package com.github.firstproject.util;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import java.sql.Connection;
import java.sql.SQLException;

public class DBConnection {

    private static final DataSource DATA_SOURCE;

    static {
        try {
            PoolProperties prop = new PoolProperties();
            prop.setDriverClassName("com.mysql.cj.jdbc.Driver");
            prop.setUrl("jdbc:mysql://localhost:3306/first_project");
            prop.setConnectionProperties("useSSL=false;useLegacyDatetimeCode=false;serverTimezone=UTC");
            prop.setUsername("root");
            prop.setPassword("root");
            prop.setJmxEnabled(true);
            prop.setTestWhileIdle(false);
            prop.setTestOnBorrow(true);
            prop.setValidationQuery("SELECT 1");
            prop.setTestOnReturn(false);
            prop.setValidationInterval(30000);
            prop.setTimeBetweenEvictionRunsMillis(30000);
            prop.setMaxActive(100);
            prop.setInitialSize(10);
            prop.setMaxWait(10000);
            prop.setRemoveAbandonedTimeout(60);
            prop.setMinEvictableIdleTimeMillis(30000);
            prop.setMinIdle(10);
            prop.setLogAbandoned(true);
            prop.setRemoveAbandoned(true);
            prop.setJdbcInterceptors("org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;" +
                    "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
            DATA_SOURCE = new DataSource();
            DATA_SOURCE.setPoolProperties(prop);
        } catch (Throwable x) {
            throw new ExceptionInInitializerError(x);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DATA_SOURCE.getConnection();
    }

    public static void close() {
        if (DATA_SOURCE != null) DATA_SOURCE.close(true);
    }
}