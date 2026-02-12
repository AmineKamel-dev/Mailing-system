package com.example.ecommerce.my_email_system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.my_email_system.model.BasicEmail;
import com.example.ecommerce.my_email_system.services.emailService;

@RestController
@RequestMapping("/internal/v1/email")
public class emailController {
    @Autowired
    emailService emailService;

    @PostMapping(path = "/basic", consumes = "application/json")
    ResponseEntity<String> handleBasicEmail(@Validated @RequestBody BasicEmail email) {
        try {
            emailService.sendMail(email);
            return ResponseEntity.ok("Email sent");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to send email: " + e.getMessage());
        }
    }

    /*
     * Not currently Needed
     *
     * @PostMapping(path = "/transaction", consumes = "application/json")
     * void handleTransactionEmail(@Validated @RequestBody TransactionEmail email) {
     * 
     * 
     * }
     */
}
