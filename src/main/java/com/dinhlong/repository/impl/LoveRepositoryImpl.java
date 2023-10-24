/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.repository.impl;

import com.dinhlong.pojos.Love;
import com.dinhlong.repository.LoveRepository;
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
public class LoveRepositoryImpl implements LoveRepository {
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Love> getLovesByProductId(int productId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Love> query = builder.createQuery(Love.class);
        Root<Love> root = query.from(Love.class);
        query = query.select(root);

        if (productId != 0) {
            query.where(builder.equal(root.get("product").get("id"), productId));
        }

        Query q = session.createQuery(query);

        return q.getResultList();
    }

    @Override
    public boolean addLove(Love love) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(love);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public Love getLoveById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Love.class, id);
    }

    @Override
    public boolean deleteLove(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Love love = this.getLoveById(id);
        try {
            session.delete(love);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Love> getLovesByUserId(int userId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Love> query = builder.createQuery(Love.class);
        Root<Love> root = query.from(Love.class);
        query = query.select(root);

        if (userId != 0) {
            query.where(builder.equal(root.get("user").get("id"), userId));
        }

        Query q = session.createQuery(query);

        return q.getResultList();
    }
}
