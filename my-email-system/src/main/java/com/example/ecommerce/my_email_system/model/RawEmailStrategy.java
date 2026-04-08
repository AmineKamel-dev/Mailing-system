package com.example.ecommerce.my_email_system.model;



import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RawEmailStrategy implements EmailRenderingStrategy {
    public EmailType getType(){return EmailType.RAW;}
    public String render(Map<String,Object> payload) {

        return payload.get("body").toString();

    }
}
