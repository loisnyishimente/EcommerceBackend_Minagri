package com.Minagri.minagri.dto;

import lombok.Getter;

@Getter
public class OrderItemDto {
    private String type;
    private String productName;
    private double price;
    private int quantity;
    private double shippingWeight;
    private String recipientEmail;


    public void setType(String type) {
        this.type = type;
    }


    public void setProductName(String productName) {
        this.productName = productName;
    }


    public void setPrice(double price) {
        this.price = price;
    }


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public void setShippingWeight(double shippingWeight) {
        this.shippingWeight = shippingWeight;
    }


    public void setRecipientEmail(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }
}
