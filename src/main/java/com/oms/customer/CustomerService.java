package com.oms.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oms.address.Address;
import com.oms.address.AddressRepository;
import com.oms.exception.CustomerNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository; 
    
    
    

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(int id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            return customer.get();
        } else {
            throw new CustomerNotFoundException("Customer Does Not Exist ");
        }
    }

    public Customer createCustomer(Customer customer) {
    	
    	
    	  Address address = customer.getAddress();
          Address savedAddress = addressRepository.save(address); 
          customer.setAddress(savedAddress); // Set the saved address to the customer
          customer.setCustomerCreationDate(new Date());
          return customerRepository.save(customer); 
    }

    public Customer updateCustomer(int id, Customer customerDetails) {
    	 Optional<Customer> existingCustomer = customerRepository.findById(id);
         if (existingCustomer.isPresent()) {
             Customer customerToUpdate = existingCustomer.get();
             
             // Update customer details
             customerToUpdate.setCustomerFirstName(customerDetails.getCustomerFirstName());
             customerToUpdate.setCustomerLastName(customerDetails.getCustomerLastName());
            
             
             
             Address updatedAddress = customerDetails.getAddress();
             Address savedAddress = addressRepository.save(updatedAddress); // Save or update the address
             customerToUpdate.setAddress(savedAddress); // Update customer's address
             
             return customerRepository.save(customerToUpdate);
         } else {
             throw new CustomerNotFoundException("Customer not found with ID: " + id);
         }
    }

    public boolean deleteCustomer(int id) {
        Optional<Customer> existingCustomer = customerRepository.findById(id);
        if (existingCustomer.isPresent()) {
            customerRepository.delete(existingCustomer.get());
            return true;
        } else {
            throw new CustomerNotFoundException("Customer Does Not Exist");
        }
    }
}