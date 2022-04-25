package com.joseloya.torrexfitness.service;

import com.joseloya.torrexfitness.model.Cart;
import com.joseloya.torrexfitness.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    @Override
    public void saveCart(Cart cart) {
        this.cartRepository.save(cart);
    }

    public boolean existsById(Long aLong) {
        return this.cartRepository.existsById(aLong);
    }

    @Override
    public Cart getCartById(Long id) {
        Optional<Cart> optional = cartRepository.findById(id);
        Cart cart = null;
        if (optional.isPresent()) {
            cart = optional.get();
        } else {
            throw new RuntimeException("Cart not found for id: " + id);
        }
        return cart;
    }

    @Override
    public void deleteCartById(Long id) {
        this.cartRepository.deleteById(id);
    }
}
