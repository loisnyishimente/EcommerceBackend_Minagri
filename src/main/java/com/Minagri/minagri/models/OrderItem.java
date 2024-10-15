package com.Minagri.minagri.models;

public abstract class OrderItem {
    protected String productName;
    protected double price;
    protected int quantity;

    public OrderItem(String productName, double price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return price * quantity;
    }

    public abstract String getDescription();
}