/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.repository.impl;

import com.dinhlong.pojos.Gearbox;
import com.dinhlong.repository.GearboxRepository;
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
public class GearboxRepositoryImpl implements GearboxRepository {
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Gearbox> getGearboxs() {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Gearbox");

        return q.getResultList();
    }

    @Override
    public Gearbox getGearboxById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Gearbox.class, id);
    }
    
    
}
