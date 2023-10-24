/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.repository.impl;

import com.dinhlong.pojos.Category;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.dinhlong.repository.CategoryRepository;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class CategoryRepositoryImpl implements CategoryRepository {
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Category> getCategories() {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Category");

        return q.getResultList();
    }

    @Override
    public Category getCategoryByCategoryName(String categoryName) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Category WHERE name=:cn");
        q.setParameter("cn", categoryName);
//        Session session = this.sessionFactory.getObject().getCurrentSession();
//        return session.get(Category.class, categoryName);

        return (Category) q.getSingleResult();
    }

    @Override
    public Category getCategoryById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Category.class, id);
    }
    
}
