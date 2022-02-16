package com.luv2code.DAO;

import com.luv2code.springdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getCustomers();

    Customer saveCustomer(Customer customer);
}
