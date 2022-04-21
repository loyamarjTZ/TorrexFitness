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

import javax.persistence.SecondaryTable;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Controller
public class CartController {
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
        if (!cartService.existsById(1L)) {
            Cart cart = new Cart(); //instantiate a cart
            cart.setCustomer(customerService.getCustomerById(1L)); //initialize cart.customer with an existing customer

            Set<CartItem> cartItemSet = new HashSet<>(); //instantiate an empty HashSet
            cart.setCartItemSet(cartItemSet); //initialize cart.cartItemSet with the empty HashSet

            cartService.saveCart(cart); //persist Cart 1 to the DB
            model.addAttribute("cartItemSet", cart.getCartItemSet()); //add the cartItemSet to the model
            return "user_shopping_cart";
        }

        //By this point, Cart 1 is confirmed to exist
        //However, it is uncertain if cart.CartItemSet is an empty HashSet or contains CartItem 1
        model.addAttribute("cartItemSet", cartService.getCartById(1L).getCartItemSet()); //add the cartItemSet to the model
        return "user_shopping_cart";
    }

//    @GetMapping("/index_carts")
//    public String getAllCarts(Model model) {
//        model.addAttribute("listCarts", cartService.getAllCarts());
//        return "all_carts";
//    }

//    @GetMapping("/showNewCartForm")
//    public String showNewCartForm(Model model) {
//        Cart cart = new Cart();
//        model.addAttribute("cart", cart);
//        return "new_cart";
//    }

}