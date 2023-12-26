package com.oms.orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // Method to get all orders for a specific customer
    public List<Order> getAllOrdersForCustomer(int customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    
    public Order getOrderForCustomer(int customerId, int orderId) {
        return orderRepository.findByCustomerIdAndOrderId(customerId, orderId);
    }

    // Method to place an order for a specific customer
    public Order placeOrderForCustomer(int customerId, Order order) {
        order.setCustomerId(customerId); // Set the customer ID for the order
        // validations 
        return orderRepository.save(order);
    }

    // Other methods for updating, deleting, adding line items, etc. as needed
}
