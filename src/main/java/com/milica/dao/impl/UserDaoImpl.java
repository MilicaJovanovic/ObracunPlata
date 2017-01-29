/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milica.dao.impl;

import java.util.List;
import com.milica.dao.UserDao;
import com.milica.entities.User;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Milica
 */
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    public UserDaoImpl() {}

    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public List<User> getUsers() {
        List<User> results = (List<User>)
        sessionFactory.getCurrentSession().createCriteria(User.class).list();
        return results;
    }

    @Override
    public User getUserById(int id) {
        User user = (User) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("id", id)).uniqueResult();
        return user;
    }

    @Override
    public void editUser(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    public User addUser(User user) {
        return (User)sessionFactory.getCurrentSession().merge(user);
    }

    @Override
    public int getCountUsers() {
        Number result = (Number) sessionFactory.getCurrentSession().createSQLQuery("select count(*) from user").uniqueResult();
        return Integer.parseInt(result.toString());
    }

    @Override
    public void deleteUser(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }
}
