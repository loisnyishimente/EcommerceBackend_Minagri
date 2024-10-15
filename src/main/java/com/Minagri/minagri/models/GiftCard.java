package com.Minagri.minagri.models;

public class GiftCard extends OrderItem {
    private final String recipientEmail;

    public GiftCard(String productName, double price, int quantity, String recipientEmail) {
        super(productName, price, quantity);
        this.recipientEmail = recipientEmail;
    }

    public void sendGift() {
        System.out.println("Sending gift card to " + recipientEmail);
    }

    @Override
    public String getDescription() {
        return "Gift Card for: " + recipientEmail;
    }
}