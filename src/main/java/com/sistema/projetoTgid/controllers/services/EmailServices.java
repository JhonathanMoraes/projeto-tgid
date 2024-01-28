
package com.sistema.projetoTgid.controllers.services;

import com.sistema.projetoTgid.models.Email;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServices {
    private final JavaMailSender mailSender;
    
    public EmailServices(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    
    public void sendEmail(Email email) {
        var mensagem = new SimpleMailMessage();
        mensagem.setFrom("noreply@email.com");
        mensagem.setTo(email.to());
        mensagem.setSubject(email.subject());
        mensagem.setText(email.body());
        mailSender.send(mensagem);
    }
}
