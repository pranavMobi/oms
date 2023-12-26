package com.oms.orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order placeOrder(Order order) {
        order.setOrderDate(new Date()); // Set the order date to the current date/time
        return orderRepository.save(order);
    }

    // Other methods as needed (update, delete, etc.)
}
