package ru.innopolis.ilnikmas.stc.lesson22.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.innopolis.ilnikmas.stc.lesson22.DBUtil;
import ru.innopolis.ilnikmas.stc.lesson22.connection.ConnectionManager;
import ru.innopolis.ilnikmas.stc.lesson22.connection.ConnectionManagerJDBCImpl;
import ru.innopolis.ilnikmas.stc.lesson22.model.Product;

import java.sql.*;
import java.util.List;

/**
 * Класс, реализующий методы для проведения операций с БД
 */

public class ProductDAOJdbcImpl implements ProductDAO {
    private static final Logger logger = LogManager.getLogger(ProductDAOJdbcImpl.class);
    private static final ConnectionManager connectionManager = ConnectionManagerJDBCImpl.getInstance();

    public ProductDAOJdbcImpl() throws SQLException {
        DBUtil.renewDatabase(connectionManager.getConnection());
    }

    /**
     * Добавление товара в БД
     * @param product
     * @return
     */
    @Override
    public Long addProduct(Product product) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO product values (DEFAULT, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, product.getProduct());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setString(3, product.getManufacturer());
            preparedStatement.setString(4, product.getOriginCountry());
            preparedStatement.executeUpdate();
            logger.info("New product {} is added", product);
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getLong(1);
                }
            }
        } catch (SQLException e) {
            logger.error(e);
        }
        return 0L;
    }

    /**
     * Получение товара по его id
     * @param id
     * @return
     */
    @Override
    public Product getProductById(Long id) {
        Product product = null;
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM product WHERE productId = ?")) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    product = new Product(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getDouble(3),
                            resultSet.getString(4),
                            resultSet.getString(5));
                    return product;
                }
                logger.info("Product with id {}: {} ", id, product);
            }
        } catch (SQLException e) {
            logger.error(e);
        }
        return null;
    }

    /**
     * Обновление параметров товара
     * @param product
     * @return
     */
    @Override
    public boolean updateProduct(Product product) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE product SET product=?, price=?, manufacturer=?, originCountry=? " +
                             "WHERE productId=?")) {
            preparedStatement.setString(1, product.getProduct());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setString(3, product.getManufacturer());
            preparedStatement.setString(4, product.getOriginCountry());
            preparedStatement.setInt(5, product.getProductId());
            preparedStatement.executeUpdate();
            logger.info("Product {} is updated", product);
            return true;
        } catch (SQLException e) {
            logger.error(e);
        }
        return false;
    }

    /**
     * Удаление товара по id
     * @param id
     * @return
     */
    @Override
    public boolean deleteProductById(Long id) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM product WHERE productId=?")) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            logger.info("Product with id {} deleted", id);
        } catch (SQLException e) {
            logger.error(e);
            return false;
        }
        return true;
    }

    /**
     * Метод, реализующий батчинг
     */
    @Override
    public void addProductByBatch(List<Product> products) throws SQLException {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO product VALUES (DEFAULT, ?, ?, ?, ?)")) {
            for (Product product : products) {
                statement.setString(1, product.getProduct());
                statement.setDouble(2, product.getPrice());
                statement.setString(3, product.getManufacturer());
                statement.setString(4, product.getOriginCountry());
                statement.addBatch();
            }
            statement.executeBatch();
            logger.info("Products added: {}", products);
        } catch (SQLException e) {
            logger.error(e);
        }
    }

    /**
     * Ручное управление транзакциями с применением savepoint и rollback
     */
    public void addDataWithSavepointAndRollback() throws SQLException {
        Connection conn = null;
        try (Connection connection = connectionManager.getConnection();
                Statement statement = connection.createStatement()) {
            conn = connection;
            connection.setAutoCommit(false);
            for (int i = 0; i < 4; i++) {
                statement.executeUpdate(
                        "INSERT INTO product (product, price, manufacturer, originCountry)\n"
                                + "VALUES\n"
                                + "   ('Beer" + i + "', " + i + ", 'Guinness', 'Ireland');"
                );
            }
            Savepoint savepoint = connection.setSavepoint();
            for (int i = 4; i < 8; i++) {
                statement.executeUpdate(
                        "INSERT INTO product (product, price, manufacturer, originCountry)\n"
                                + "VALUES\n"
                                + "   ('Beer" + i + "', " + i + ", 'Guinness', 'Ireland');"
                );
            }
            connection.rollback(savepoint);
            connection.commit();
            logger.info("Transaction committed");
        } catch (SQLException e) {
            conn.rollback();
            logger.error(e);
        }
    }
}
