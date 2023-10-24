/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.repository.impl;

import com.dinhlong.pojos.Brand;
import com.dinhlong.repository.BrandRepository;
import java.util.List;
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
public class BrandRepositoryImpl implements BrandRepository {
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Brand> getBrands() {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Brand");

        return q.getResultList();
    }

    @Override
    public Brand getBrandById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Brand.class, id);
    }
    
}
