package ru.innopolis.ilnikmas.stc.lesson19.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Класс, реализующий подключение к БД с заданными параметрами
 */

public class ConnectionManagerJDBCImpl implements ConnectionManager{
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
