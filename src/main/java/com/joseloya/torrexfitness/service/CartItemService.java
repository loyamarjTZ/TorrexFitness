package com.joseloya.torrexfitness.service;

import com.joseloya.torrexfitness.model.CartItem;

import java.util.List;

public interface CartItemService {
    List<CartItem> getAllCartItems();

    boolean existsById(Long aLong);

    void saveCartItem(CartItem cartItem);

    CartItem getCartItemById(Long id);

    void deleteCartItemById(Long id);
}
