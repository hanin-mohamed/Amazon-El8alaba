package com.adminPanel.app.service;

import com.adminPanel.app.dao.ProductDAO;
import com.adminPanel.app.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Transactional
    public void addProduct(Product product) {
        productDAO.addProduct(product);
    }

    @Transactional
    public void updateProduct(Product product) {
        productDAO.updateProduct(product);
    }

    @Transactional
    public Product findById(int id) {
        return productDAO.findProductById(id);
    }

    @Transactional
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    @Transactional
    public void deleteProduct(int id) {
        productDAO.deleteProduct(id);
    }
}