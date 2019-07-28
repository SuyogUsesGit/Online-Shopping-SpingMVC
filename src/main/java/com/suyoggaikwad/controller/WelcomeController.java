package com.suyoggaikwad.controller;

import com.suyoggaikwad.model.ItemForm;
import com.suyoggaikwad.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;


@Controller
@SessionAttributes("availabilityMsg")
public class WelcomeController {

    private ItemService itemService;

    @Autowired
    public WelcomeController(ItemService itemService) {
        this.itemService = itemService;
    }

    @ModelAttribute
    public void itemFormMA(Model model) {
        ItemForm itemForm = new ItemForm();
        itemForm.setItems(itemService.getItems());
        model.addAttribute("itemForm", itemForm);
    }


    @GetMapping("/Welcome")
    public String getItems(ModelMap modelMap) {
        ItemForm itemForm = (ItemForm) modelMap.get("itemForm");
        if(itemForm.getItems().size() > 0) modelMap.addAttribute("availabilityMsg", "What would you like to buy today?");
        else modelMap.addAttribute("availabilityMsg", "Sorry! We are currently out of stock");
        return "welcome";
    }


}
