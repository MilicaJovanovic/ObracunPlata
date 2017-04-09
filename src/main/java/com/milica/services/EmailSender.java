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
    final static String username = "milica.jovanovic@metropolitan.ac.rs";
    final static String password = "Monopol123";
    final static String to ="milica.jovanovic.2317@metropolitan.ac.rs";
//    private static final String FILE = "c:/Users/Milica/Documents/NetBeansProjects/ObracunPlata/src/main/resources/izvestaji/ObracunPlataIzvestaj.pdf";
    
    
    
    public static void sendMail(String mail, List<Person> employees) throws AddressException, MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "mail.metropolitan.ac.rs");
        props.put("mail.smtp.port", "587");
        
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(username, password);
            }
        });
        
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject("Informacija o zaradi");
        message.setText(mail);
        
        MimeBodyPart textBodyPart = new MimeBodyPart();
        textBodyPart.setContent(mail, "text/html; charset=utf-8");
            
        for (Person person : employees) {
            System.out.println(person.toString());
            String FILE = "c:/Users/Milica/Documents/NetBeansProjects/ObracunPlata/src/main/resources/obracuni/" + person.getName() + person.getLastname() + ".pdf";
            System.out.println(FILE);
            
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            Multipart multipart = new MimeMultipart();
            messageBodyPart = new MimeBodyPart();
            String file = FILE;
            String fileName = "Obracun plate.pdf";
            DataSource source = new FileDataSource(file);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(fileName);
            multipart.addBodyPart(textBodyPart);
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);
            System.out.println(message.toString());
            Transport.send(message);
        }
    }
}
