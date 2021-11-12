package com.devrev.apirest.service;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class EnviaEmailService {

	private String login = "revemailsend@gmail.com";
	private String senha = "Revemailsend@";
	
	public void enviarEmail(String assunto, String emailDestino, String mensagem) throws MessagingException  {
		
		Properties properties = new Properties();

		properties.put("mail.smtp.ssl.trust", "*"); // Criptografia SSL
		
		properties.put("mail.smtp.auth", "true"); /* Autorização */

		properties.put("mail.smtp.starttls", "true"); /* Autenticação */

		properties.put("mail.smtp.host", "smtp.gmail.com"); /* Servidor do Gmail */

		properties.put("mail.smtp.port", "465"); /* Porta do Servidor do Google */

		properties.put("mail.smtp.socketFactory.port", "465"); /* Expecifica a porta a ser conectada pelo socket */

		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); /* Classe socket de conexão ao SMTP */

		properties.put("mail.smtp.ssl.trust", "*"); /* Cria uma Autenticação SSL */
		
		// Autenticação do email e senha do email que está enviando 
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(login, senha);
			}
		});
		
		Address[] toUser = InternetAddress.parse(emailDestino);
		
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(login)); // Quem está enviando
		message.setRecipients(Message.RecipientType.TO, toUser); // Para quem vai o email
		message.setSubject(assunto); // Assunto do email
		message.setText(mensagem); // Mensagem do Email
		
		Transport.send(message);
	}
	
}
