package com.Minagri.minagri.models;

public class DigitalProduct extends OrderItem {

    public DigitalProduct(String productName, double price, int quantity) {
        super(productName, price, quantity);
    }

    public String generateDownloadLink() {
        return "https://example.com/download/" + productName.replace(" ", "-");
    }

    @Override
    public String getDescription() {
        return "Digital Product: " + productName;
    }
}