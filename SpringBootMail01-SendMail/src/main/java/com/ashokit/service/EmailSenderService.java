package com.ashokit.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
	@Autowired 
	private JavaMailSender mailSender;
	
	public void sendSimpleEmail(String toEmail, 
															String body, 
															String subject) {
		
		SimpleMailMessage message=new SimpleMailMessage();
		
		message.setFrom("ashoksharma14feb@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);
		
		mailSender.send(message);
		System.out.println("mail sent");
	}
	
	public void sendEmailWithAttachment(String toEmail,
																				String body,
																				String subject,
																				String attachment) {
		MimeMessage mimeMessage=mailSender.createMimeMessage(); //
		
	}

}
