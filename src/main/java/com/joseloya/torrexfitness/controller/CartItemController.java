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
//
//    @GetMapping("/index_products")
//    public String getAllProducts(Model model) {
//        model.addAttribute("listProducts", productService.getAllProducts());
//        return "all_products";
//    }
////
//    @PostMapping("/saveCartItem")
//    public String saveCartItem(@ModelAttribute("cartItem") @Valid CartItem cartItem, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "new_product";
//        }
//        cartItemService.saveCartItem(cartItem);
//        return "redirect:/index_products";
//    }
//
//    @GetMapping("/showNewProductForm")
//    public String showNewProductForm(Model model) {
//        Product product = new Product();
//        model.addAttribute("product", product);
//        return "new_product";
//    }
//
//    @GetMapping("/showFormForProductUpdate/{id}")
//    public String showFormForProductUpdate(@PathVariable(value = "id") long id, Model model) {
//        Product product = productService.getProductById(id);
//        model.addAttribute("product", product);
//        return "update_product";
//    }
//
//    @GetMapping("/showProductGallery")
//    public String showProductGallery(Model model) {
//        model.addAttribute("listProducts", productService.getAllProducts());
////        model.addAttribute("cart_item", new Product());
//        return "user_product_gallery";
//    }
//
//    @GetMapping("/addProductToCart")
//    public String addProductToCart(Model model){
//        CartItem cartItem = new CartItem(); // "property-empty" cartItem object
////        productService.getProductById(1L).setQuantity(1);
//        cartItem.setProduct(productService.getProductById(1L)); //set product property to first product
//        cartItem.getProduct().setQuantity(1); //set quantity property to 1
//        cartService.getCartById(1L).getCartItemSet().add(cartItem); //add the "property-filled" cartItem to the cartItemSet of Cart 1
//        model.addAttribute("cartItemSet", cartService.getCartById(1L).getCartItemSet()); //add the cartItemSet to the model
//        return "user_shopping_cart"; //go to the Customer's Cart
//    }
}

