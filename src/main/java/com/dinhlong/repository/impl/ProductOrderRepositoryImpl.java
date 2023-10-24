/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.repository.impl;

import com.dinhlong.pojos.ProductOrder;
import com.dinhlong.repository.ProductOrderRepository;
import java.util.List;
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
public class ProductOrderRepositoryImpl implements ProductOrderRepository {
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public boolean addProductOrder(ProductOrder productOrder) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(productOrder);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public List<ProductOrder> getProductOrders() {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From ProductOrder");

        return q.getResultList();
    }

    @Override
    public ProductOrder getProductOrderById(int id) {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From ProductOrder");
        
        List<ProductOrder> productOrders = q.getResultList();
        
        for (ProductOrder c: productOrders) {
            if (id == c.getId()) return c;
        }
        
        return new ProductOrder();
    }

    @Override
    public boolean updateProductOrder(ProductOrder productOrder) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.update(productOrder);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteProductOrder(ProductOrder productOrder) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.delete(productOrder);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }
    
}
