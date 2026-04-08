package com.example.ecommerce.my_email_system.model;

import lombok.SneakyThrows;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;


import java.nio.charset.StandardCharsets;
import java.util.Map;

//TODO:replace with html rendering

@Component
public class WelcomeEmailStrategy implements EmailRenderingStrategy {
    public EmailType getType(){return EmailType.WELCOME;}
    @SneakyThrows
    public String render(Map<String,Object> payload)  {
            //parse username
            String username = payload.get("username").toString();
            ClassPathResource resource = new ClassPathResource("templates/welcome.html");
            return  new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);


    }
}
