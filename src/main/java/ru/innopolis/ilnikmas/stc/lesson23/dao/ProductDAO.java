package ru.innopolis.ilnikmas.stc.lesson23.dao;

import ru.innopolis.ilnikmas.stc.lesson23.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {
    Long addProduct(Product product);

    Product getProductById(Long id);

    boolean updateProduct(Product product);

    boolean deleteProductById(Long id);

    void addProductByBatch(List<Product> products) throws SQLException;

    void addDataWithSavepointAndRollback() throws SQLException;
}
