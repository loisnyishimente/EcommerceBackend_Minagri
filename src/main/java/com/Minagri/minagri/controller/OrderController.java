package com.Minagri.minagri.controller;

import com.Minagri.minagri.dto.OrderItemDto;
import com.Minagri.minagri.models.DigitalProduct;
import com.Minagri.minagri.service.OrderService;
import com.Minagri.minagri.models.PhysicalProduct;
import com.Minagri.minagri.models.OrderItem;
import com.Minagri.minagri.models.GiftCard;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final Map<Integer, OrderService> orderDatabase = new HashMap<>();
    private int orderIdCounter = 1;

    @PostMapping
    public ResponseEntity<Map<String, Object>> createOrder() {
        OrderService newOrder = new OrderService();
        orderDatabase.put(orderIdCounter, newOrder);

        Map<String, Object> response = new HashMap<>();
        response.put("orderId", orderIdCounter++);
        response.put("message", "Order created successfully.");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{orderId}/items")
    public ResponseEntity<Map<String, String>> addItemToOrder(@PathVariable int orderId, @RequestBody OrderItemDto orderItemDto) {
        OrderService order = orderDatabase.get(orderId);
        if (order == null) {
            return ResponseEntity.notFound().build();
        }

        OrderItem item;
        switch (orderItemDto.getType()) {
            case "PhysicalProduct":
                item = new PhysicalProduct(orderItemDto.getProductName(), orderItemDto.getPrice(), orderItemDto.getQuantity(), orderItemDto.getShippingWeight());
                break;
            case "DigitalProduct":
                item = new DigitalProduct(orderItemDto.getProductName(), orderItemDto.getPrice(), orderItemDto.getQuantity());
                break;
            case "GiftCard":
                item = new GiftCard(orderItemDto.getProductName(), orderItemDto.getPrice(), orderItemDto.getQuantity(), orderItemDto.getRecipientEmail());
                break;
            default:
                return ResponseEntity.badRequest().body(Map.of("message", "Invalid product type."));
        }

        order.addItem(item);
        return ResponseEntity.ok(Map.of("message", "Item added to order."));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Map<String, Object>> getOrderSummary(@PathVariable int orderId) {
        OrderService order = orderDatabase.get(orderId);
        if (order == null) {
            return ResponseEntity.notFound().build();
        }

        Map<String, Object> response = new HashMap<>();
        response.put("orderId", orderId);
        response.put("items", order.getItems());
        response.put("totalPrice", order.calculateTotal());
        response.put("totalShippingCost", order.calculateTotalShipping());

        return ResponseEntity.ok(response);
    }
}
