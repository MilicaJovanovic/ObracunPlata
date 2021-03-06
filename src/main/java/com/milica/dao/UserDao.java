package com.milica.dao;

import java.util.List;
import com.milica.entities.User;

/**
 *
 * @author Milica
 * Interfejs sadrzi metode koje se koriste za komunikacija sa bazom podataka
 */
public interface UserDao {
	
	public boolean addUser(User user);
	public boolean editUser(User user);
	public boolean deleteUser(User user);
	public User getUserById(int id);
        public List<User> getUsers();
        public int getCountUsers();
    
}
