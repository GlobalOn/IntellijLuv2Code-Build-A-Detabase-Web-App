package com.luv2code.Service;

import com.luv2code.DAO.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerDAO customerDAO;

    public CustomerServiceImpl() {
    }

    @Autowired
    public CustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Transactional
    public Customer saveCustomer(Customer customer) {
        return customerDAO.saveCustomer(customer);
    }
}
