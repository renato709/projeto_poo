package com.example.sistema.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;

public class DBConnection {
    private static final String PROPERTIES_FILE = "/db.properties";

    public static Connection getConnection() throws SQLException {
        try (InputStream in = DBConnection.class.getResourceAsStream(PROPERTIES_FILE)) {
            Properties props = new Properties();
            props.load(in);
            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String pass = props.getProperty("db.password");
            return DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            throw new SQLException("Erro ao carregar propriedades do banco: " + e.getMessage(), e);
        }
    }
}
