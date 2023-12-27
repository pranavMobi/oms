package com.oms.orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private OrderItemRepository orderItemRepository;

    // Method to get all orders for a specific customer
    public List<Order> getAllOrdersForCustomer(int customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    
    public Order getOrderForCustomer(int customerId, int orderId) {
        return orderRepository.findByCustomerIdAndOrderId(customerId, orderId);
    }

    
    public Order placeOrderForCustomer(int customerId, Order order) {
        order.setCustomerId(customerId);

        Order savedOrder = orderRepository.save(order);

        List<OrderItem> orderItems = order.getOrderItems();
        orderItems.forEach(item -> {
            item.setOrderId(savedOrder.getOrderId());
            item.setOrder(savedOrder); // Set the saved Order instance for each OrderItem
        });

        orderItemRepository.saveAll(orderItems);

        return savedOrder;
    }
}
