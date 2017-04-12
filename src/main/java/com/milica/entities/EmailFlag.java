package com.milica.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entitet klasa koja mapira tabelu "email_flag"
 * @author Milica
 */
@Entity
@Table(name="email_flag")
public class EmailFlag implements Serializable {
    
    private int emailFlagId;
    private int flag;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "email_flag_id")
    public int getEmailFlagId() {
        return emailFlagId;
    }
    public void setEmailFlagId(int emailFlagId) {
        this.emailFlagId = emailFlagId;
    }
    
    @Column(name = "flag")
    public int getFlag() {
        return flag;
    }
    public void setFlag(int flag) {
        this.flag = flag;
    }
    
    @Override
    public String toString() {
            return "EmailFlag [emailFlagId=" + emailFlagId + ", flag=" + flag + "]";
    }
}
