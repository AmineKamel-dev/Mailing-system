package com.example.ecommerce.my_email_system.model;


import java.util.Map;

public interface EmailRenderingStrategy {
    public EmailType getType();
    public String render(Map<String,Object> payload);
}
