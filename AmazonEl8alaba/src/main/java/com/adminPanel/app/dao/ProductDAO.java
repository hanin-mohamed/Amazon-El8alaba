package com.adminPanel.app.dao;

import com.adminPanel.app.model.Product;
import java.util.List;

public interface ProductDAO {
     void addProduct(Product product);
     void updateProduct(Product product);
     void deleteProduct(int id);
     Product findProductById(int id);
     List<Product> getAllProducts();
}