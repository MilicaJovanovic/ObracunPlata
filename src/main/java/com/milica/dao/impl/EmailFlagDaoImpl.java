package com.milica.dao.impl;

import com.milica.dao.EmailFlagDao;
import com.milica.entities.EmailFlag;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * DAO sloj koji se koristi za pristup tabeli "email_flag" u bazi podataka
 * @author Milica
 */
public class EmailFlagDaoImpl implements EmailFlagDao {
    @Autowired
    private SessionFactory sessionFactory;

    public EmailFlagDaoImpl() {}

    public EmailFlagDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public boolean addEmailFlag(EmailFlag emailFlag) {
        EmailFlag currentEmailFlag = currentEmailFlag(emailFlag);

        if (currentEmailFlag == null) {
                sessionFactory.getCurrentSession().save(emailFlag);
                return true;
        }

        return false;
    }

    @Override
    @Transactional
    public boolean editEmailFlag(EmailFlag emailFlag) {
            EmailFlag currentEmailFlag = currentEmailFlag(emailFlag);

            if (currentEmailFlag == null) {
                    return false;
            }

            sessionFactory.getCurrentSession().update(emailFlag);
            return true;
    }

    @Override
    @Transactional
    public boolean deleteEmailFlag(EmailFlag emailFlag) {
            EmailFlag currentEmailFlag = currentEmailFlag(emailFlag);

            if (currentEmailFlag == null) {
                    return false;
            }

            sessionFactory.getCurrentSession().delete(currentEmailFlag);
            return true;
    }

    @Override
    @Transactional
    public EmailFlag getEmailFlagById(int id) {
            EmailFlag currentEmailFlag = (EmailFlag) sessionFactory.getCurrentSession()
                            .createCriteria(EmailFlag.class)
                            .add(Restrictions.eq("emailFlagId", id))
                            .uniqueResult();
            return currentEmailFlag;
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<EmailFlag> getEmailFlags() {
            return sessionFactory.getCurrentSession()
                            .createCriteria(EmailFlag.class)
                            .list();
    }

    @Override
    @Transactional
    public int getCountEmailFlags() {
            List<EmailFlag> allEmailFlags = getEmailFlags();

            if (allEmailFlags == null) {
                    return 0;
            }
            return allEmailFlags.size();
    }

    private EmailFlag currentEmailFlag(EmailFlag EmailFlag) {
            EmailFlag currentEmailFlag = (EmailFlag) sessionFactory.getCurrentSession()
                            .createCriteria(EmailFlag.class)
                            .add(Restrictions.eq("emailFlagId", EmailFlag.getEmailFlagId()))
                            .uniqueResult();
            return currentEmailFlag;
    }
}
