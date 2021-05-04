package ru.innopolis.ilnikmas.stc.lesson23;

import ru.innopolis.ilnikmas.stc.lesson23.connection.ConnectionManager;
import ru.innopolis.ilnikmas.stc.lesson23.connection.ConnectionManagerJDBCImpl;
import ru.innopolis.ilnikmas.stc.lesson23.dao.ProductDAO;
import ru.innopolis.ilnikmas.stc.lesson23.dao.ProductDAOJdbcImpl;
import ru.innopolis.ilnikmas.stc.lesson23.model.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        ConnectionManager connectionManager = ConnectionManagerJDBCImpl.getInstance();
        DBUtil.renewDatabase(connectionManager.getConnection());
        ProductDAO productDAO = new ProductDAOJdbcImpl(connectionManager);
        //Добавление новой записи в БД
        Product product = new Product(null, "Tequila", 35.80, "Aztec", "Mexico");
        Long productId = productDAO.addProduct(product);
        product = productDAO.getProductById(productId);
        System.out.println(product);
        //Обновление записи в БД
        product.setPrice(28.55);
        productDAO.updateProduct(product);
        product = productDAO.getProductById(productId);
        System.out.println(product);
        //Удаление записи из БД
        productDAO.deleteProductById(productId);
        product = productDAO.getProductById(productId);
        System.out.println(product);
        System.out.println("Продукт по ИД: " + productDAO.getProductById(4L));
        //Батчинг
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(null, "Vine", 157.34, "Bordo", "France"));
        productList.add(new Product(null, "Chocolate", 17.07, "Alpen Gold", "Swiss"));
        productList.add(new Product(null, "Cocaine", 9999.99, "Don Pedro", "Columbia"));
        productDAO.addProductByBatch(productList);
    }
}
