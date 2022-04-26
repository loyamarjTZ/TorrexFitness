package com.joseloya.torrexfitness.controller;

import com.joseloya.torrexfitness.model.Cart;
import com.joseloya.torrexfitness.model.CartItem;
import com.joseloya.torrexfitness.repository.CartRepository;
import com.joseloya.torrexfitness.repository.CustomerRepository;
import com.joseloya.torrexfitness.service.CartItemService;
import com.joseloya.torrexfitness.service.CartService;
import com.joseloya.torrexfitness.service.CartServiceImpl;
import com.joseloya.torrexfitness.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class CartController {
    private static final Double TAX_8_PERCENT = 0.08;

    private CartService cartService;
    private CustomerService customerService;
    private CartItemService cartItemService;

    @Autowired
    public CartController(CartService cartService,
                          CustomerService customerService,
                          CartItemService cartItemService) {
        this.cartService = cartService;
        this.customerService = customerService;
        this.cartItemService = cartItemService;
    }

    @PostMapping("/saveCart")
    public String saveCart(@ModelAttribute("cart") Cart cart) {
        cartService.saveCart(cart);
        return "redirect:/index_carts";
    }

    @GetMapping("/updateCart/{id}")
    public String showFormForCartUpdate(@PathVariable(value = "id") long id, Model model) {
        Cart cart = cartService.getCartById(id);
        model.addAttribute("cart", cart);
        return "update_cart";
    }

    @GetMapping("/deleteCart/{id}")
    public String deleteCart(@PathVariable(value = "id") long id) {
        this.cartService.deleteCartById(id);
        return "redirect:/index_carts";
    }

    @GetMapping("/showCustomerCart")
    public String showCustomerCart(Model model) {
        Double subtotal = 0.0;
        Double tax = 0.0;
        Double total = 0.0;

        // check if cart 1 exists in the DB
        // if not: instantiate, initialize, and persist cart 1
        if (!cartService.existsById(1L)) {
            Cart cart = new Cart(); //instantiate a cart
            cart.setCustomer(customerService.getCustomerById(1L)); //initialize cart.customer with an existing customer

            Set<CartItem> cartItemSet = new HashSet<>(); //instantiate an empty HashSet
            cart.setCartItemSet(cartItemSet); //initialize cart.cartItemSet with the empty HashSet

            cartService.saveCart(cart); //persist Cart 1 to the DB
//            model.addAttribute("cartItemSet", cart.getCartItemSet()); //add the cartItemSet to the model
            model.addAttribute("subtotal", subtotal);
            model.addAttribute("tax", tax);
            model.addAttribute("total", total);
            return "user_shopping_cart";
        }

        // check if the cartItemSet property of cart 1 contains at least one cartItem
        // if so: calculate the subtotal, tax, and total to be paid
        // otherwise: subtotal, tax, and total must be 0
        if (cartService.getCartById(1L).getCartItemSet().size() >= 1) {
            for (CartItem i : cartService.getCartById(1L).getCartItemSet()) {
                subtotal += i.getProduct().getPrice();
            }
            tax = subtotal * TAX_8_PERCENT;
            total = subtotal + tax;

            // By this point:
            // 1. Cart 1 is confirmed to exist
            // 2. cartItemSet property of Cart 1 contains at least one cartItem
            // 3. subtotal, tax, and total must be greater than 0, assuming cartItem.product.price is also greater than 0

            model.addAttribute("subtotal", subtotal);
            model.addAttribute("tax", tax);
            model.addAttribute("total", total);
            model.addAttribute("cartItemSet", cartService.getCartById(1L).getCartItemSet()); //add the cartItemSet to the model
            return "user_shopping_cart";
        }

        // By this point:
        // 1. Cart 1 is confirmed to exist
        // 2. cartItemSet property of Cart 1 contains no cartItems
        // 3. subtotal, tax, and total are 0
        model.addAttribute("subtotal", subtotal);
        model.addAttribute("tax", tax);
        model.addAttribute("total", total);
        model.addAttribute("cartItemSet", cartService.getCartById(1L).getCartItemSet()); //add the cartItemSet to the model
        return "user_shopping_cart";
    }
}