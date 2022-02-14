package com.luv2code.Controller;

import com.luv2code.DAO.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CustomerController {

    private CustomerDAO customerDAO;

    //injecting customer DAO
    @Autowired
    public CustomerController(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @RequestMapping("/customers")
    public String listCustomers(Model theModel){

        //get customers from dao
        List<Customer> customerList = customerDAO.getCustomers();
        //add customers to theModel
        theModel.addAttribute("customerList", customerList);
        System.out.println(customerList);
        return "list-customers";
    }
}
