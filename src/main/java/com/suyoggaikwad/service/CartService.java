package com.suyoggaikwad.service;

import com.suyoggaikwad.dao.CartDao;
import com.suyoggaikwad.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private CartDao cartDao;

    @Autowired
    public CartService(CartDao cartDao) {
        this.cartDao = cartDao;
    }

    public boolean addCartItem(List<Cart> cartItems) {
        return cartDao.addCartItem(cartItems);
    }

    public List<Cart> getAllCartItems() {
        return cartDao.getAllCartItems();
    }

    public List<Cart> checkout(int userId) {
        return cartDao.checkout(userId);
    }
}
