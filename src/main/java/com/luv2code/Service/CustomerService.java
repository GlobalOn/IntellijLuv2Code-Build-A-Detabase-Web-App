package com.luv2code.Service;

import com.luv2code.springdemo.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    Customer saveCustomer(Customer customer);
}
