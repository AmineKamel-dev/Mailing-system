package com.example.ecommerce.my_email_system.model;

import lombok.SneakyThrows;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Map;

//TODO: use Order field for templateEngine

@Component
public class OrderEmailStrategy implements EmailRenderingStrategy {

    @Override
    public EmailType getType(){return EmailType.ORDER_CONFIRMATION;}

    @SneakyThrows
    @Override
    public String render(Map<String,Object> payload)  {
        //parse order components
        String orderId = payload.get("orderId").toString();
        // Use order fields with Html engine
        ClassPathResource resource = new ClassPathResource("templates/orderConfirmation.html");
        return  new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);


    }
}
