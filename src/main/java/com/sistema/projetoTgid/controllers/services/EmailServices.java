
package com.sistema.projetoTgid.controllers.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServices {
    private static JavaMailSender mailSender;
    
    public EmailServices(JavaMailSender mailSender) {
        EmailServices.mailSender = mailSender;
    }
    
    public static void sendEmail(String to, String subject, String body) {
    	SimpleMailMessage message = new SimpleMailMessage();
    	
        message.setFrom("noreply@email.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        
        mailSender.send(message);
    }
}
