package com.adminPanel.app.dao;

import com.adminPanel.app.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class ProductDAOImp implements ProductDAO {

    private static final Logger logger = Logger.getLogger(com.adminPanel.app.dao.ProductDAOImp.class.getName());

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.save(product);
        logger.info("Product added: " + product);
    }

    @Override
    public void updateProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.update(product);
        logger.info("Product updated: " + product);
    }

    @Override
    public void deleteProduct(int id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = session.get(Product.class, id);
        if (product != null) {
            session.delete(product);
            logger.info("Product deleted: " + product);
        } else {
            logger.warning("Product not found for deletion. ID: " + id);
            throw new RuntimeException("Product not found with ID: " + id);
        }
    }

    @Override
    public Product findProductById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = session.get(Product.class, id);
        if (product == null) {
            logger.warning("Product not found. ID: " + id);
            throw new RuntimeException("Product not found with ID: " + id);
        }
        logger.info("Product found: " + product);
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        Session session = sessionFactory.getCurrentSession();
        List<Product> products = session.createQuery("from Product", Product.class).getResultList();
        logger.info("Products retrieved: " + products.size());
        return products;
    }
}