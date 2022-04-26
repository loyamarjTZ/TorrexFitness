package com.joseloya.torrexfitness.controller;

import com.joseloya.torrexfitness.model.CartItem;
import com.joseloya.torrexfitness.model.Product;
import com.joseloya.torrexfitness.service.CartItemService;
import com.joseloya.torrexfitness.service.CartService;
import com.joseloya.torrexfitness.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CartItemController {
    private ProductService productService;
    private CartService cartService;
    private CartItemService cartItemService;

    @Autowired
    public CartItemController(ProductService productService,
                              CartService cartService,
                              CartItemService cartItemService) {
        this.productService = productService;
        this.cartService = cartService;
        this.cartItemService = cartItemService;
    }

    @GetMapping("/deleteCartItem/{id}")
    public String deleteCartItem(@PathVariable(value = "id") Long id) {
        cartService.getCartById(1L).getCartItemSet().remove(cartItemService.getCartItemById(1L));
        cartItemService.deleteCartItemById(id);
        return "redirect:/showCustomerCart";
    }
}

