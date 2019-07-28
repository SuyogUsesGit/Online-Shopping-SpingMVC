package com.suyoggaikwad.controller;

import com.suyoggaikwad.model.Cart;
import com.suyoggaikwad.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
public class CheckoutController {

    private CartService cartService;

    @Autowired
    public CheckoutController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/Checkout")
    public String checkout(@SessionAttribute int userID, ModelMap modelMap) {
        List<Cart> cartList = cartService.checkout(userID);
        if(!cartList.isEmpty()) {
            modelMap.addAttribute("Success", "Thank you for shopping with us!");
            modelMap.addAttribute("cartList", cartList);
        }
        return "checkout";
    }
}
