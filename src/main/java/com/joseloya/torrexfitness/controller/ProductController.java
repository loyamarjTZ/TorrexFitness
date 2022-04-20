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

//    @Autowired
//    private ProductService productService;
//    private CartService cartService;

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
//        model.addAttribute("cart_item", new Product());
        return "user_product_gallery";
    }

    @GetMapping("/addProductToCart")
    public String addProductToCart(Model model){
        if(!cartService.existsById(1L)) {
            Cart cart = new Cart();
            cart.setCustomer(customerService.getCustomerById(1L));
            cartService.saveCart(cart);
        }

        CartItem cartItem = new CartItem(); // "property-empty" cartItem object
        cartItem.setProduct(productService.getProductById(1L)); //set product property to first product
        cartItemService.saveCartItem(cartItem);

        Set<CartItem> cartItemSet = new HashSet<>();
        cartItemSet.add(cartItem);
        cartService.getCartById(1L).setCartItemSet(cartItemSet);

        model.addAttribute("cartItemSet", cartService.getCartById(1L).getCartItemSet()); //add the cartItemSet to the model
        return "user_shopping_cart"; //go to the Customer's Cart
    }
}

