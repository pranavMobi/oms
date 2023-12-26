package com.oms.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository; // Assuming you have a CustomerRepository

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(int id) {
        return customerRepository.findById(id).orElse(null);
    }

    public Customer createCustomer(Customer customer) {
    	 customer.setCustomerCreationDate(new Date());
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(int id, Customer customerDetails) {
        Customer existingCustomer = customerRepository.findById(id).orElse(null);
        if (existingCustomer != null) {
            // Update existingCustomer with customerDetails
            // (You can use setters or mapping libraries like MapStruct here)
            // For example:
            existingCustomer.setCustomerFirstName(customerDetails.getCustomerFirstName());
            existingCustomer.setCustomerLastName(customerDetails.getCustomerLastName());
            // ... Update other fields similarly

            return customerRepository.save(existingCustomer);
        }
        return null;
    }

    public boolean deleteCustomer(int id) {
        Customer existingCustomer = customerRepository.findById(id).orElse(null);
        if (existingCustomer != null) {
            customerRepository.delete(existingCustomer);
            return true;
        }
        return false;
    }
}
