package com.adminPanel.app.dao;

import com.adminPanel.app.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class ProductDAOImp implements ProductDAO {

    private static final Logger logger = Logger.getLogger(ProductDAOImp.class.getName());

    private final SessionFactory sessionFactory;

    @Autowired
    public ProductDAOImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void addProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        if (product.getProductDetails() != null) {
            product.getProductDetails().setProduct(product);
        }

        session.save(product);
        logger.info("Product added: " + product);
    }

    @Override
    @Transactional
    public void updateProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        if (product.getProductDetails() != null) {
            product.getProductDetails().setProduct(product);
        }

        session.update(product);
        logger.info("Product updated: " + product);
    }

    @Override
    @Transactional
    public void deleteProduct(int id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = session.get(Product.class, id);
        session.delete(product);
        logger.info("Product deleted: " + product);
    }

    @Override
    @Transactional
    public Product findProductById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = session.get(Product.class, id);
        logger.info("Product found: " + product);
        return product;
    }

    @Override
    @Transactional
    public List<Product> getAllProducts() {
        Session session = sessionFactory.getCurrentSession();
        List<Product> products = session.createQuery("from Product", Product.class).getResultList();
        logger.info("Products retrieved: " + products.size());
        return products;
    }
}