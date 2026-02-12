package com.example.ecommerce.my_email_system.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.ecommerce.my_email_system.model.BasicEmail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class emailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendMail(BasicEmail mail) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper msg = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        msg.setTo(mail.getTo());
        if (mail.getSubject() != null)
            msg.setSubject(mail.getSubject());
        else
            msg.setSubject("no Subject");
        msg.setText(mail.getHTML(), true);

        mailSender.send(msg.getMimeMessage());
    }
    // DIFFERENT IMPLEMENTATIONS OF sendMail() MIGHT BE NEEDED IN THE FUTURE

}
// requires : documentation of :
// JavaMailSender
// configuration of the sender in application.properties
// simplemailMessage
