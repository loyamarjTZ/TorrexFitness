package com.joseloya.torrexfitness.controller;

import com.joseloya.torrexfitness.model.Cart;
import com.joseloya.torrexfitness.model.CartItem;
import com.joseloya.torrexfitness.repository.CartRepository;
import com.joseloya.torrexfitness.repository.CustomerRepository;
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
import java.util.Set;

@Controller
public class CartController {
    private CartService cartService;
    private CustomerService customerService;

    @Autowired
    public CartController(CartService cartService, CustomerService customerService) {
        this.cartService = cartService;
        this.customerService = customerService;
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
        if(!cartService.existsById(1L)) {
            Cart cart = new Cart();
            cart.setCustomer(customerService.getCustomerById(1));
            cartService.saveCart(cart);
            model.addAttribute("customerCart", cartService.getCartById(1));
            //System.out.println(cart.getId());
            return "user_shopping_cart";
        }
        model.addAttribute("customerCart", cartService.getCartById(1));
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