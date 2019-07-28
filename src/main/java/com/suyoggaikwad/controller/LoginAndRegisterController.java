package com.suyoggaikwad.controller;

import com.suyoggaikwad.model.Customer;
import com.suyoggaikwad.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@Controller
@SessionAttributes({"userName", "userID"})
public class LoginAndRegisterController {

    private CustomerService customerService;

    @Autowired
    public LoginAndRegisterController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // -- Adding ModelAttributes --

   @GetMapping("/loginPage")
   public String loginPage() {
        return "login";
   }

    @GetMapping("/registerPage")
    public String regirsterPage() {
        return "register";
    }

    @ModelAttribute
    public void customerMA(Model model) {
        model.addAttribute("customer", new Customer());
    }

    // -- Servlets --

    @GetMapping("/ValidateCustomer")
    public String validateCustomer(Customer customer, ModelMap modelMap) {
        int id = customerService.validateCustomer(customer);
        if(id==-1) {
            modelMap.addAttribute("loginMessage", "Invalid login details! Please try again..");
            return "login";
        } else {
            modelMap.addAttribute("userID", id);
            modelMap.addAttribute("userName", customer.getUsername());
            return "redirect:/Welcome";
        }
    }

    @PostMapping("/RegisterCustomer")
    public String registerCustomer(@Valid Customer customer, BindingResult result, Model model) {
        if(result.hasErrors()) {
            model.addAttribute("regMsg", "Incorrect format for username or password!");
            return "register";
        }
        boolean status = customerService.registerCustomer(customer);
        if(!status) {
            model.addAttribute("regMsg", "Username already exists. Please choose a different username");
            return "register";
        } else {
            model.addAttribute("loginMessage", "Registered Successfully! Please Login to continue.");
            return "login";
        }
    }



}
