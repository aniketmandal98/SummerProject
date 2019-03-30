package SendEmail;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;


public class EmailSend {

    public static void email(String ipAddress,String emailId){
        
        try {
            String host = "smtp.gmail.com";
            String user = "abcd090909090abcd@gmail.com";
            String pass = "aniket12345";
            //String to = "aniketmandal98@gmail.com";
            String from = "abcd090909090abcd@gmail.com";
            String subject = "This is confirmation for the account.";
            boolean sessionDebug = false;

            Properties props = System.getProperties();
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");
            props.put("mail.smtp.user", "abcd090909090abcd@gmail.com");
            props.put("mail.smtp.host", "smtp.gmail.com");
            //props.put("mail.smtp.port", "25");
            props.put("mail.debug", "true");
            //props.put("mail.smtp.auth", "true");
            //props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.EnableSSL.enable", "true");

            props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.setProperty("mail.smtp.socketFactory.fallbac k", "false");
            //props.setProperty("mail.smtp.port", "465");
            props.setProperty("mail.smtp.socketFactory.port", "465");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(emailId)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject);
            msg.setSentDate(new Date());
            
            msg.setText("Your IP Address: " +ipAddress+" is down.");
            
            Transport transport = mailSession.getTransport("smtps");
            transport.connect(host,user,pass);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
            System.out.println("message send successfully");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("mail not sent, you are in exception.");
        }
      
    }
    
}

    

