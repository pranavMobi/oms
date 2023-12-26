package com.oms.orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers/{customerId}/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAllOrdersForCustomer(@PathVariable int customerId) {
        return orderService.getAllOrdersForCustomer(customerId);
    }

    @GetMapping("/{orderId}")
    public Order getOrderForCustomer(@PathVariable int customerId, @PathVariable int orderId) {
        return orderService.getOrderForCustomer(customerId, orderId);
    }

    @PostMapping
    public Order placeOrderForCustomer(@PathVariable int customerId, @RequestBody Order order) {
        return orderService.placeOrderForCustomer(customerId, order);
    }

    // Other endpoints for update, delete, line items, etc.
}
