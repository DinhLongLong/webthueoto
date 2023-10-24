/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.repository.impl;

import com.dinhlong.pojos.Product;
import com.dinhlong.repository.ProductRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<Product> getProducts() {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Product");

        return q.getResultList();
    }

    @Override
    public Product getProductById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Product.class, id);
    }

    @Override
    public List<Product> getProductsByUserId(int userId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Product> query = builder.createQuery(Product.class);
        Root<Product> root = query.from(Product.class);
        query = query.select(root);

        if (userId != 0) {
            query.where(builder.equal(root.get("user").get("id"), userId));
        }

        Query q = session.createQuery(query);

        return q.getResultList();
    }

    @Override
    public List<Product> getProductsByCategoryId(int categoryId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Product> query = builder.createQuery(Product.class);
        Root<Product> root = query.from(Product.class);
        query = query.select(root);

        if (categoryId != 0) {
            query.where(builder.equal(root.get("category").get("id"), categoryId));
        }

        Query q = session.createQuery(query);

        return q.getResultList();
    }

    @Override
    public boolean addProduct(Product product) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(product);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        
        return false;
    }

    @Override
    public boolean deleteProduct(Product product) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.delete(product);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
}
