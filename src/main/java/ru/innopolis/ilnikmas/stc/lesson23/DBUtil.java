package ru.innopolis.ilnikmas.stc.lesson23;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Класс содержит метод для переинициализации БД
 */

public class DBUtil {
    private static final Logger logger = LogManager.getLogger(DBUtil.class);

    private DBUtil() {
    }

    public static void renewDatabase(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute("-- Database: postgres\n"
                    + "DROP TABLE IF EXISTS product;"
                    + "\n"
                    + "CREATE TABLE product (\n"
                    + "    productId bigserial primary key,\n"
                    + "    product varchar(100) NOT NULL,\n"
                    + "    price float NOT NULL,\n"
                    + "    manufacturer varchar(100) NOT NULL,\n"
                    + "    originCountry varchar(100) NOT NULL);"
                    + "\n"
                    + "INSERT INTO product (product, price, manufacturer, originCountry)\n"
                    + "VALUES\n"
                    + "   ('Laptop', 1000.00, 'Apple', 'China'),\n"
                    + "   ('Smartphone', 500.00, 'Zopo', 'Malaysia'),\n"
                    + "   ('Car', 25000, 'BMW', 'Germany'),\n"
                    + "   ('Rifle', 500.00, 'IZHMASH', 'Russia'),\n"
                    + "   ('Potato', 1.50, 'KOLHOZ', 'Belarus');"
                    + "\n"
                    + "DROP FUNCTION IF EXISTS multiply(integer);"
                    + "\n"
                    + "CREATE OR REPLACE FUNCTION multiply(a INT, b INT) RETURNS INT AS $$\n"
                    + "DECLARE\n"
                    + "    price int;\n"
                    + "BEGIN\n"
                    + "    SELECT product.price INTO price FROM product WHERE productId = b;\n"
                    + "    return product * a;\n"
                    + "END\n"
                    + "$$ LANGUAGE 'plpgsql';");
            logger.info("DB is reinited");
        }
    }
}
