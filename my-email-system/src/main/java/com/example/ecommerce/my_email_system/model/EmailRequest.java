package com.example.ecommerce.my_email_system.model;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
@Scope("request")
public class EmailRequest {
    @NotNull
    private String to;
    @NotNull
    private String subject;
    @NotNull
    private EmailType type;
    @NotNull
    private Map<String,Object> payload;


    private LocalDateTime timestamp;


    public EmailRequest(String to, String subject, EmailType type, Map<String, Object> payload) {
        this.to =to;
        this.subject = subject;
        this.type = type;
        this.payload = payload;
        this.timestamp = LocalDateTime.now();
    }





}
