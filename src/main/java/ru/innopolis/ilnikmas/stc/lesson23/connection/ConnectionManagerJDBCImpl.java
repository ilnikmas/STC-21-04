package ru.innopolis.ilnikmas.stc.lesson23.connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Класс, реализующий подключение к БД с заданными параметрами
 */

public class ConnectionManagerJDBCImpl implements ConnectionManager {
    private static final Logger logger = LogManager.getLogger(ConnectionManagerJDBCImpl.class);
    public static final ConnectionManager INSTANCE = new ConnectionManagerJDBCImpl();
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    private ConnectionManagerJDBCImpl(){
    }

    public static ConnectionManager getInstance(){return INSTANCE;}

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            logger.info("Connection to database established");
        } catch (SQLException e) {
            logger.error("Connection error: {}", e.getMessage());
        }
        return connection;
    }
}
