package com.joseloya.torrexfitness.service;

import com.joseloya.torrexfitness.model.Product;
import com.joseloya.torrexfitness.service.ProductService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductServiceImplTest {

    @Autowired
    private ProductService productService;

    @Test
    public void should_return_true_when_at_least_one_product_exists_in_DB(){
        List<Product> productList = productService.getAllProducts();
        Product product = productList.get(0);
        if(product != null){
            Product product2 = productService.getProductById(1L);
            Assertions.assertThat(product2.getId()).isEqualTo(1L);
        }
    }
}
