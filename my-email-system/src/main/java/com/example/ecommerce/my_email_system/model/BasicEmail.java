package com.example.ecommerce.my_email_system.model;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDateTime;

import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//TODO: replace with an email Factory for better scalability
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BasicEmail {
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", flags = Pattern.Flag.CASE_INSENSITIVE)
    @JsonProperty("email")
    @NotBlank(message = "Email adress should not be Blank")
    private String to;

    @JsonProperty("subject")
    private String subject;

    @JsonProperty("body")
    private String body;

    private LocalDateTime timestamp;

    public BasicEmail(String reciever) {
        this.to = reciever;
        this.timestamp = LocalDateTime.now();
    }

    // TODO : implement thymleaf engine for loading welcome template
    public String getHTML() {
        try {
            ClassPathResource resource = new ClassPathResource("src/main/resources");
            byte[] bytes = Files.readAllBytes(resource.getFile().toPath());
            return new String(bytes, StandardCharsets.UTF_8);
        } catch (IOException e) {
            return "Failed";
        }
    }
}
