package com.joseloya.torrexfitness.service;

import com.joseloya.torrexfitness.model.Cart;

import java.util.List;

public interface CartService {
    List <Cart> getAllCarts();
    void saveCart(Cart cart);
    Cart getCartById(long id);
    void deleteCartById(long id);
}