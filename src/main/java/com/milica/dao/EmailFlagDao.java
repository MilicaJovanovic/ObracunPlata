package com.milica.dao;

import com.milica.entities.EmailFlag;
import java.util.List;

/**
 *
 * @author Milica
 * Interfejs sadrzi metode koje se koriste za komunikacija sa bazom podataka
 */
public interface EmailFlagDao {
    public void setGenerated();
    public void setUngenerated();
    public boolean addEmailFlag(EmailFlag emailFlag);
    public boolean editEmailFlag(EmailFlag emailFlag);
    public boolean deleteEmailFlag(EmailFlag emailFlag);
    public EmailFlag getEmailFlagById(int id);
    public List<EmailFlag> getEmailFlags();
    public int getCountEmailFlags();
}
