package com.example.ecommerce.my_email_system.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class TransactionEmail extends BasicEmail {
    @Getter
    @NotBlank(message = "OrderID should not be blank")
    @JsonProperty("orderID")
    private final String orderID;

    @Getter
    @JsonProperty("userID")
    private final String userID;

    public TransactionEmail(String reciever, String order, String user) {
        super(reciever);
        this.orderID = order;
        this.userID = user;
    }

    // TODO: implement thymleaf engine for loading transaction template
    @Override
    public String getHTML() {
        return "<html><body><h2>transaction Email  Placeholder</h2></body></html>\n";

    }

}
