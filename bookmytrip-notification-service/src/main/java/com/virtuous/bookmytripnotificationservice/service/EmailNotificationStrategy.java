package com.virtuous.bookmytripnotificationservice.service;

import com.virtuous.bookmytripnotificationservice.dto.EmailMessage;
import com.virtuous.bookmytripnotificationservice.dto.NotificationMessage;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class EmailNotificationStrategy implements NotificationStrategy{

    private final JavaMailSender mailSender;
    @Value("${spring.mail.username}") private String sender;

    public EmailNotificationStrategy(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void send(NotificationMessage message) {

        if (((EmailMessage)message).getAttachment() == null) {
            sendSimpleMail(message);
        } else {
            sendMailWithAttachment(message);
        }

    }

    public void sendMailWithAttachment(NotificationMessage message) {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        try {

            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(((EmailMessage)message).getRecipient());
            mimeMessageHelper.setText(message.getMessageBody());
            mimeMessageHelper.setSubject(((EmailMessage)message).getSubject());

            // Adding the attachment
            FileSystemResource file = new FileSystemResource(new File(((EmailMessage)message).getAttachment()));

            mimeMessageHelper.addAttachment(file.getFilename(), file);


            mailSender.send(mimeMessage);
        }


        catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendSimpleMail(NotificationMessage message) {

        try{

            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setFrom(sender);
            mailMessage.setTo(((EmailMessage)message).getRecipient());
            mailMessage.setText(message.getMessageBody());
            mailMessage.setSubject(((EmailMessage)message).getSubject());

            mailSender.send(mailMessage);
        } catch (MailException e) {
            throw new RuntimeException(e);
        }
    }

}
