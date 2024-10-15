package com.Minagri.minagri.service;
import com.Minagri.minagri.models.OrderItem;
import com.Minagri.minagri.models.PhysicalProduct;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private final List<OrderItem> items = new ArrayList<>();

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public double calculateTotal() {
        return items.stream().mapToDouble(OrderItem::getTotalPrice).sum();
    }

    public double calculateTotalShipping() {
        return items.stream()
                .filter(item -> item instanceof PhysicalProduct)
                .mapToDouble(item -> ((PhysicalProduct) item).calculateShippingCost())
                .sum();
    }

    public void printSummary() {
        items.forEach(item -> System.out.println(item.getDescription()));
        System.out.println("Total Price: " + calculateTotal() + " Rwf");
        System.out.println("Total Shipping Cost: " + calculateTotalShipping() + " Rwf");
    }

    public Object getItems() {
        return null;
    }
}