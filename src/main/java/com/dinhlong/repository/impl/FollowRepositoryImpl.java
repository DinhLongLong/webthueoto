/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.repository.impl;

import com.dinhlong.pojos.Follow;
import com.dinhlong.repository.FollowRepository;
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
public class FollowRepositoryImpl implements FollowRepository {
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public boolean addFollow(Follow follow) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(follow);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteFollow(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Follow follow = this.getFollowById(id);
        try {
            session.delete(follow);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public Follow getFollowById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Follow.class, id);
    }

    @Override
    public List<Follow> getFollowsByFollowerId(int followerId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Follow> query = builder.createQuery(Follow.class);
        Root<Follow> root = query.from(Follow.class);
        query = query.select(root);

        if (followerId != 0) {
            query.where(builder.equal(root.get("follower").get("id"), followerId));
        }

        Query q = session.createQuery(query);

        return q.getResultList();
    }

    @Override
    public List<Follow> getFollowsByUserId(int userId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Follow> query = builder.createQuery(Follow.class);
        Root<Follow> root = query.from(Follow.class);
        query = query.select(root);

        if (userId != 0) {
            query.where(builder.equal(root.get("user").get("id"), userId));
        }

        Query q = session.createQuery(query);

        return q.getResultList();
    }
    
}
