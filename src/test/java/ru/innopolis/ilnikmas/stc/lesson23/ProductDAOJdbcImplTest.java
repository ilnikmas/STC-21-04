package ru.innopolis.ilnikmas.stc.lesson23;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.Spy;
import ru.innopolis.ilnikmas.stc.lesson23.connection.ConnectionManagerJDBCImpl;
import ru.innopolis.ilnikmas.stc.lesson23.model.Product;
import ru.innopolis.ilnikmas.stc.lesson23.connection.ConnectionManager;
import ru.innopolis.ilnikmas.stc.lesson23.dao.ProductDAO;
import ru.innopolis.ilnikmas.stc.lesson23.dao.ProductDAOJdbcImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

class ProductDAOJdbcImplTest {
    private static final Logger logger = LogManager.getLogger(ProductDAOJdbcImplTest.class);
    private ProductDAO productDAO;
    @Spy
    private ConnectionManager connectionManager = ConnectionManagerJDBCImpl.getInstance();
    @Mock
    private Connection connection;
    @Mock
    private PreparedStatement preparedStatement;
    @Mock
    private ResultSet resultSet;

    private static final int PRODUCT_ID = 1;
    private static final String PRODUCT_NAME = "Printer";
    private static final Double PRICE = 150.45;
    private static final String MANUFACTURER = "Canon";
    private static final String ORIGIN_COUNTRY = "Japan";

    @BeforeEach
    void setUp() throws SQLException {
        initMocks(this);
        doReturn(connection).when(connectionManager).getConnection();
        productDAO = new ProductDAOJdbcImpl(connectionManager);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addProduct() throws SQLException {
        when(connection.prepareStatement(ProductDAOJdbcImpl.INSERT_INTO_PRODUCT, Statement.RETURN_GENERATED_KEYS)).thenReturn(preparedStatement);
        when(preparedStatement.getGeneratedKeys()).thenReturn(resultSet);
        when(resultSet.next()).thenReturn(true);
        when(resultSet.getLong(1)).thenReturn(1L);
        final Product product = new Product();
        product.setProductId(PRODUCT_ID);
        product.setProduct(PRODUCT_NAME);
        product.setPrice(PRICE);
        product.setManufacturer(MANUFACTURER);
        product.setOriginCountry(ORIGIN_COUNTRY);
        Long aLong = productDAO.addProduct(product);
        assertEquals(1L, aLong);
        verify(connection, atMost(1))
                .prepareStatement(ProductDAOJdbcImpl.INSERT_INTO_PRODUCT, Statement.RETURN_GENERATED_KEYS);
        verify(preparedStatement).executeUpdate();
    }

    @Test
    void getProductById() throws SQLException {
        when(connection.prepareStatement(ProductDAOJdbcImpl.SELECT_FROM_PRODUCT)).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(resultSet.next()).thenReturn(true);
        when(resultSet.getInt(1)).thenReturn(PRODUCT_ID);
        when(resultSet.getString(2)).thenReturn(PRODUCT_NAME);
        when(resultSet.getDouble(3)).thenReturn(PRICE);
        when(resultSet.getString(4)).thenReturn(MANUFACTURER);
        when(resultSet.getString(5)).thenReturn(ORIGIN_COUNTRY);
        Product expectedProduct = new Product(PRODUCT_ID, PRODUCT_NAME, PRICE, MANUFACTURER, ORIGIN_COUNTRY);
        Product actualProduct = productDAO.getProductById(1L);
        assertTrue(expectedProduct.getProductId().equals(actualProduct.getProductId())
                && expectedProduct.getProduct().equals(actualProduct.getProduct())
                && expectedProduct.getPrice().equals(actualProduct.getPrice())
                && expectedProduct.getManufacturer().equals(actualProduct.getManufacturer())
                && expectedProduct.getOriginCountry().equals(actualProduct.getOriginCountry()));
    }

    @Test
    void updateProduct() throws SQLException {
        Double newPrice = 300.00;
        final Product product = new Product();
        product.setProductId(PRODUCT_ID);
        product.setProduct(PRODUCT_NAME);
        product.setPrice(newPrice);
        product.setManufacturer(MANUFACTURER);
        product.setOriginCountry(ORIGIN_COUNTRY);
        when(connection.prepareStatement(ProductDAOJdbcImpl.UPDATE_PRODUCT)).thenReturn(preparedStatement);
        productDAO.updateProduct(product);
        verify(preparedStatement).executeUpdate();
    }

    @Test
    void deleteProductById() throws SQLException {
        when(connection.prepareStatement(ProductDAOJdbcImpl.DELETE_FROM_PRODUCT)).thenReturn(preparedStatement);
        productDAO.deleteProductById(1L);
        verify(preparedStatement).executeUpdate();
    }

    @Test
    void addProductByBatch() throws SQLException {
        List<Product> products = new ArrayList<>();
        products.add(new Product(PRODUCT_ID, PRODUCT_NAME, PRICE, MANUFACTURER, ORIGIN_COUNTRY));
        products.add(new Product(2, "AAA", 100.00, "CCC", "EEE"));
        products.add(new Product(3, "BBB", 200.00, "DDD", "FFF"));
        when(connection.prepareStatement(ProductDAOJdbcImpl.ADD_BATCH)).thenReturn(preparedStatement);
        productDAO.addProductByBatch(products);
        verify(preparedStatement).executeBatch();
    }

    @AfterAll
    static void tearDownAll() {

    }
}