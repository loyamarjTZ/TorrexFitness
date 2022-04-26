package com.joseloya.torrexfitness.controller;

import com.joseloya.torrexfitness.model.Cart;
import com.joseloya.torrexfitness.model.CartItem;
import com.joseloya.torrexfitness.model.Product;
import com.joseloya.torrexfitness.service.CartItemService;
import com.joseloya.torrexfitness.service.CartService;
import com.joseloya.torrexfitness.service.CustomerService;
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
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Controller
public class ProductController {

    private ProductService productService;
    private CartService cartService;
    private CartItemService cartItemService;
    private CustomerService customerService;

    @Autowired
    public ProductController(ProductService productService,
                             CartService cartService,
                             CartItemService cartItemService,
                             CustomerService customerService) {
        this.cartService = cartService;
        this.productService = productService;
        this.cartItemService = cartItemService;
        this.customerService = customerService;
    }

    @GetMapping("/index_products")
    public String getAllProducts(Model model) {
        model.addAttribute("listProducts", productService.getAllProducts());
        return "all_products";
    }
//
    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new_product";
        }
        productService.saveProduct(product);
        return "redirect:/index_products";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable(value = "id") long id) {
        this.productService.deleteProductById(id);
        return "redirect:/index_products";
    }

    @GetMapping("/showNewProductForm")
    public String showNewProductForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "new_product";
    }

    @GetMapping("/showFormForProductUpdate/{id}")
    public String showFormForProductUpdate(@PathVariable(value = "id") long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "update_product";
    }

    @GetMapping("/showProductGallery")
    public String showProductGallery(Model model) {
        model.addAttribute("listProducts", productService.getAllProducts());
        return "user_product_gallery";
    }

    @GetMapping("/addProductToCart")
    public String addProductToCart(Model model){
        final Double TAX_8_PERCENT = 0.08;

        Double subtotal = 0.00;
        Double tax = 0.00;
        Double total = 0.00;

        // Check if a Cart with ID #1 exists in the DB
        // If not: create, initialize the properties, and persist a Cart with an ID of 1
        if(!cartService.existsById(1L)) {
            Cart cart = new Cart(); //instantiate a cart
            cart.setCustomer(customerService.getCustomerById(1L)); //initialize cart.customer with an existing customer
            Set<CartItem> cartItemSet = new HashSet<>(); //instantiate cartItemSet with an empty HashSet
            cart.setCartItemSet(cartItemSet); //initialize cart.cartItemSet with the empty HashSet
            cartService.saveCart(cart); //persist the cart to the DB
        }

        // Check if CartItem #1 exists in the DB
        // If not: create, initialize the properties, and persist a CartItem with an ID of 1
        if(!cartItemService.existsById(1L)) {
            CartItem cartItem = new CartItem(); //instantiate a cartItem
            cartItem.setProduct(productService.getProductById(1L)); //initialize cartItem.product with an existing product
            cartItemService.saveCartItem(cartItem); //persist cartItem to the DB
        }

        // Check if Cart ID 1 contains CartItem ID  1
        // If not: initialize the cartItemSet property of cart 1 so that it contains cartItem 1
        if (!cartService.getCartById(1L).getCartItemSet().contains(cartItemService.getCartItemById(1L))) {
            Set<CartItem> cartItemSet = new HashSet<>(); //instantiate cartItemSet with an empty HashSet
            cartItemSet.add(cartItemService.getCartItemById(1L)); //add CartItem 1 to cartItemSet
            Cart tempCart = cartService.getCartById(1L); //instantiate a cart
            tempCart.setCartItemSet(cartItemSet); //initialize tempCart.cartItemSet with the cartItemSet containing CartItem 1
            cartService.saveCart(tempCart);
        }

        // By this point:
        // 1. Cart 1 is initialized and persisted in the DB
        // 2. CartItem 1 is initialized and persisted in the DB
        // 3. The cartItemSet property of Cart 1 contains cartItem 1

        for (CartItem i : cartService.getCartById(1L).getCartItemSet()) {
            subtotal += i.getProduct().getPrice();
        }
        tax = subtotal * TAX_8_PERCENT;
        total = subtotal + tax;

        model.addAttribute("subtotal", subtotal);
        model.addAttribute("tax", tax);
        model.addAttribute("total", total);

        // Add the current state of the cartItemSet property of Cart 1 to the model
        model.addAttribute("cartItemSet", cartService.getCartById(1L).getCartItemSet());
        return "user_shopping_cart"; //go to the Customer's Cart
    }
}

