package com.milica.services;

import com.milica.dto.Person;
import java.util.*;

import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Milica
 */
public class EmailSender {
    final static String USERNAME = "milica.jovanovic@metropolitan.ac.rs";
    final static String PASSWORD = "Monopol123";
    final static String TO ="milica.jovanovic.2317@metropolitan.ac.rs";

    public static void sendMail(String mail, Person person) throws AddressException, MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host","mail.metropolitan.ac.rs");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(USERNAME, PASSWORD);
            }
        });
//        String to = person.getName() + "." + person.getLastname() + "@metropolitan.ac.rs";
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(USERNAME));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(TO));
        message.setSubject("Obracun o isplacenoj plati");
        message.setText(mail);

        MimeBodyPart textBodyPart = new MimeBodyPart();
        textBodyPart.setContent(mail, "text/html; charset=utf-8");

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        Multipart multipart = new MimeMultipart();
        messageBodyPart = new MimeBodyPart();
        String file = "c:/Users/Milica/Documents/NetBeansProjects/ObracunPlata/src/main/resources/obracuni/" + person.getName() + person.getLastname() + ".pdf";
        String fileName = "ObracunPlate.pdf";
        DataSource source = new FileDataSource(file);
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName(fileName);
        multipart.addBodyPart(textBodyPart);
        multipart.addBodyPart(messageBodyPart);
        message.setContent(multipart);
        Transport.send(message);
    }
}
