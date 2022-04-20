package com.joseloya.torrexfitness.service;

import com.joseloya.torrexfitness.model.Cart;

import java.util.List;

public interface CartService {
    List <Cart> getAllCarts();
    void saveCart(Cart cart);
    boolean existsById(Long aLong);
    Cart getCartById(Long id);
    void deleteCartById(Long id);
}