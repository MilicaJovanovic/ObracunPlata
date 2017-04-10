/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milica.dao;

import com.milica.entities.EmailFlag;
import com.milica.entities.User;
import java.util.List;

/**
 *
 * @author Milica
 */
public interface EmailFlagDao {
    public boolean addEmailFlag(EmailFlag emailFlag);
    public boolean editEmailFlag(EmailFlag emailFlag);
    public boolean deleteEmailFlag(EmailFlag emailFlag);
    public EmailFlag getEmailFlagById(int id);
    public List<EmailFlag> getEmailFlags();
    public int getCountEmailFlags();
}
