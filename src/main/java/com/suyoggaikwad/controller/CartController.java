package com.suyoggaikwad.controller;

import com.suyoggaikwad.model.Cart;
import com.suyoggaikwad.model.Item;
import com.suyoggaikwad.model.ItemForm;
import com.suyoggaikwad.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {

    private CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/cartPage")
    public String cartPage(ModelMap modelMap) {
        List<Cart> cartList = cartService.getAllCartItems();
        modelMap.addAttribute("cartItems", cartList);
        if(cartList.isEmpty()) modelMap.addAttribute("emptyCartMsg", "Your cart is empty!");
        else modelMap.addAttribute("emptyCartMsg", "Your cart contains following items:");
        return "cart";
    }

    @GetMapping("/AddToCart")
    public String addToCart(ItemForm itemForm, @SessionAttribute int userID, Model model){
        List<Cart> cartList = new ArrayList<>();
        for (Item item: itemForm.getItems()) {
            Cart cart = new Cart();
            cart.setUserId(userID);
            cart.setItemId(item.getId());
            cart.setItemName(item.getName());
            cart.setQuantity(item.getQuantityEntered());
            cart.setPrice(item.getPriceIncurred());
            cartList.add(cart);
        }
        if(cartService.addCartItem(cartList)) {
            model.addAttribute("Success", "Your cart has been successfully updated!");
            return "welcome";
        }
        else return null;
    }
}
