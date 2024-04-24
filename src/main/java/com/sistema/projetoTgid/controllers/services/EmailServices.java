
package com.sistema.projetoTgid.controllers.services;

import java.util.Properties;

import org.springframework.stereotype.Service;

import com.sistema.projetoTgid.models.Transacao;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServices {
	
    public static void sendEmail(InternetAddress[] recipients, Transacao transacao) throws MessagingException {
    	Properties props = new Properties();
    	props.put("mail.smtp.auth", "true");
    	props.put("mail.smtp.starttls.enable", "true");
    	props.put("mail.smtp.host", "sandbox.smtp.mailtrap.io");
    	props.put("mail.smtp.port", "587");
    	
    	Session session = Session.getInstance(props,
    		    new jakarta.mail.Authenticator() {
    		        protected PasswordAuthentication getPasswordAuthentication() {
    		            return new PasswordAuthentication("08cf9e99ce30a8", "14143f6e9e19e0");
    		        }
    		    });
    	
    	Message email = new MimeMessage(session);
    	email.setFrom(new InternetAddress("noreply@server.com"));
    	email.addRecipients(Message.RecipientType.TO, recipients);
    	email.setSubject("Transação realizada!");
    	
    	String htmlText = "<html><body><h1>" + transacao.getTipoTransacao() + " realizado com sucesso!</h1>"
    	+ "<h3>Detalhes</h3>"
    	+ "<p><strong>Tipo de transação:</strong> " + transacao.getTipoTransacao()
    	+ "<p><strong>Valor:</strong> R$" + transacao.getValor()
    	+ "<hr>"
    	+ "<p><strong>Email do cliente:</strong> " + recipients[0]
    	+ "<p><strong>Email da empresa:</strong> " + recipients[1]
    	+ "</body></html>";
    	
    	email.setContent(htmlText, "text/html; charset=utf-8");
        
        Transport.send(email);
    }
}
