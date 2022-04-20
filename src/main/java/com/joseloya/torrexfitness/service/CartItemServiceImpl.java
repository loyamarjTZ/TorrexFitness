package com.joseloya.torrexfitness.service;

import com.joseloya.torrexfitness.model.CartItem;
import com.joseloya.torrexfitness.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    @Override
    public void saveCartItem(CartItem cartItem) {
        this.cartItemRepository.save(cartItem);
    }

    @Override
    public CartItem getCartItemById(Long id) {

        return cartItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CartItem not found"));
//        Optional<CartItem> optional = cartItemRepository.findById(id);
//        CartItem cartItem = null;
//        if (optional.isPresent()) {
//            cartItem = optional.get();
//        } else {
//            throw new RuntimeException(" CartItem not found for id :: " + id);
//        }
//        return cartItem;
    }

    @Override
    public void deleteCartItemById(Long id) {
        this.cartItemRepository.deleteById(id);
    }
}
