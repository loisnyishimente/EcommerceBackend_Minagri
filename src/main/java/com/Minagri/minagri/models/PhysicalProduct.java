package com.Minagri.minagri.models;

public class PhysicalProduct extends OrderItem {
    private final double shippingWeight;

    public PhysicalProduct(String productName, double price, int quantity, double shippingWeight) {
        super(productName, price, quantity);
        this.shippingWeight = shippingWeight;
    }

    public double calculateShippingCost() {
        return shippingWeight * 500;
    }

    @Override
    public String getDescription() {
        return "Physical Product: " + productName + " (Weight: " + shippingWeight + " kg)";
    }
}