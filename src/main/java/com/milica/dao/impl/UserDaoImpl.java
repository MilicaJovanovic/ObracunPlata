package com.milica.dao.impl;

import java.util.List;
import com.milica.dao.UserDao;
import com.milica.entities.User;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * DAO sloj koji se koristi za pristup tabeli "user" u bazi podataka
 * @author Milica
 */
@Repository
public class UserDaoImpl implements UserDao {
    
    @Autowired
    private SessionFactory sessionFactory;

    public UserDaoImpl() {}

    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@Override
	@Transactional
	public boolean addUser(User user) {
		User currentUser = currentUser(user);
		
		if (currentUser == null) {
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		
		return false;
	}

	@Override
	@Transactional
	public boolean editUser(User user) {
		User currentUser = currentUser(user);
		
		if (currentUser== null) {
			return false;
		}
		
		sessionFactory.getCurrentSession().update(user);
		return true;
	}

	@Override
	@Transactional
	public boolean deleteUser(User user) {
		User currentUser = currentUser(user);
		
		if (currentUser == null) {
			return false;
		}
		
		sessionFactory.getCurrentSession().delete(currentUser);
		return true;
	}

	@Override
	@Transactional
	public User getUserById(int id) {
		User currentUser = (User) sessionFactory.getCurrentSession()
				.createCriteria(User.class)
				.add(Restrictions.eq("userId", id))
				.uniqueResult();
		return currentUser;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<User> getUsers() {
		return sessionFactory.getCurrentSession()
				.createCriteria(User.class)
				.list();
	}

	@Override
	@Transactional
	public int getCountUsers() {
		List<User> allUsers = getUsers();
		
		if (allUsers == null) {
			return 0;
		}
		return allUsers.size();
	}
    
	private User currentUser(User user) {
		User currentUser = (User) sessionFactory.getCurrentSession()
				.createCriteria(User.class)
				.add(Restrictions.eq("username", user.getUsername()))
				.uniqueResult();
		return currentUser;
	}
	
}
