package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class H2ConnectionFactory implements ConnectionFactory {
    @Override
    public Connection createConnection() {
        Connection connection = null;
        try(InputStream propertiesFile = new FileInputStream("src/main/resources/h2database.properties")) {
            Properties properties = new Properties();
            properties.load(propertiesFile);

            String url = properties.getProperty("db_url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");

            connection = DriverManager.getConnection(url, user, password);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

