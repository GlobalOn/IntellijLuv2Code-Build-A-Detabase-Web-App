package com.luv2code.Controller;

import com.luv2code.Service.CustomerService;
import com.luv2code.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CustomerController {

    private CustomerService customerService;

    //injecting customer DAO
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public String listCustomers(Model theModel) {

        //get customers from dao
        List<Customer> customerList = customerService.getCustomers();
        //add customers to theModel
        theModel.addAttribute("customerList", customerList);
        System.out.println(customerList);
        return "list-customers";
    }
}
