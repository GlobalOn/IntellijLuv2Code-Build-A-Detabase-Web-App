package com.luv2code.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/l")
public class CustomerController {

    @RequestMapping("/customers")
    public String listCustomers(Model theModel){
        return "list-customers";
    }
}
