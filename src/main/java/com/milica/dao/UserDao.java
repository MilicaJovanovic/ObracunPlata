/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milica.dao;

import java.util.List;
import com.milica.entities.User;

/**
 *
 * @author Milica
 */
public interface UserDao {
    public List<User> getUsers();
    public User getUserById(int id);
    public void editUser(User user);
    public User addUser(User user);
    public int getCountUsers();
    public void deleteUser(User user);
}
