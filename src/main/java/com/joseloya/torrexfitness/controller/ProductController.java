package com.joseloya.torrexfitness.controller;

import com.joseloya.torrexfitness.model.Product;
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
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/index_products")
    public String getAllProducts(Model model) {
        model.addAttribute("listProducts", productService.getAllProducts());
        return "all_products";
    }

    @GetMapping("/showNewProductForm")
    public String showNewProductForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "new_product";
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

    @GetMapping("/showFormForProductUpdate/{id}")
    public String showFormForProductUpdate(@PathVariable(value = "id") long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "update_product";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable(value = "id") long id) {
        this.productService.deleteProductById(id);
        return "redirect:/index_products";
    }
}

