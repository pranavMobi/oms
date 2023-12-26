package com.oms.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	List<Customer> findAll();
    Customer findByCustomerId(int id);

  
    List<Customer> findByCustomerFirstName(String firstName);

   
    List<Customer> findByCustomerLastName(String lastName);

   
    Customer save(Customer customer);

    
    void deleteByCustomerId(int id);

  

}
