package com.example.ecommerce.my_email_system.services;

import com.example.ecommerce.my_email_system.model.EmailRenderingStrategy;
import com.example.ecommerce.my_email_system.model.StrategyResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.ecommerce.my_email_system.model.EmailRequest;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class emailService {

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private StrategyResolver resolver;

    public void sendMail(EmailRequest mail) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper msg = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        msg.setTo(mail.getTo());
        if (mail.getSubject() != null)
            msg.setSubject(mail.getSubject());
        else
            msg.setSubject("no Subject");
        EmailRenderingStrategy strategy =resolver.resolve(mail.getType());
        msg.setText(strategy.render(mail.getPayload()), true);

        mailSender.send(msg.getMimeMessage());
    }


}
