package com.adminPanel.app.dao;

import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAOImp implements ProductDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void addProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.update(product);
    }

    @Override
    public void updateProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.update(product);
    }

    @Override
    public void deleteProduct(int id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = session.get(Product.class, id);
        if (product != null) {
            session.delete(product);
        } else {
            throw new RuntimeException("Product not found with ID: " + id);
        }
    }

    @Override
    public Product findProductById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = session.get(Product.class, id);
        if (product == null) {
            throw new RuntimeException("Product not found with ID: " + id);
        }
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Product", Product.class).getResultList();
    }
}
