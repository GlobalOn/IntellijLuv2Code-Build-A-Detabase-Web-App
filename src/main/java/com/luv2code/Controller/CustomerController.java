package com.luv2code.Controller;

import com.luv2code.Service.CustomerService;
import com.luv2code.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        //Create a model attribute to bind a form data
        Customer newCustomer = new Customer();

        theModel.addAttribute("newCustomer", newCustomer);

        return "customer-form";
    }

    @GetMapping("/showFormForUpdateCustomer")
    public String showFormForUpdateCustomer(@RequestParam("customerId")Integer id, Model theModel) {

        //Get Customer from the service by Id
            Customer theCustomer = customerService.getCustomerById(id);
        //Set Customer as a model attribute to pre-populate the form
            theModel.addAttribute("newCustomer", theCustomer);
        //Send over to our form

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("newCustomer") Customer newCustomer) {
            customerService.saveCustomer(newCustomer);
        return "redirect:/customers";
    }
}
