package com.milica.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entitet klasa koja mapira tabelu "user"
 * @author Milica
 */
@Entity
@Table(name="users")
public class User implements Serializable {
	
    private int userId;
    private String username;
    private String password;
    private int enabled;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "username")
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name="password")
    public String getPassword() {
		return password;
	}
    public void setPassword(String password) {
		this.password = password;
	}
    
    @Column(name = "enabled")
    public int getEnabled() {
        return enabled;
    }
    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }
    
    @Override
    public String toString() {
            return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", enabled=" + enabled + "]";
    }
}
