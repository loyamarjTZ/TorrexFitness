package com.joseloya.torrexfitness.service;

import com.joseloya.torrexfitness.model.Cart;
import com.joseloya.torrexfitness.service.CartService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CartServiceImplTest {

    @Autowired
    private CartService cartService;

    @Test
    public void should_return_true_when_at_least_one_cart_exists_in_DB(){
        List<Cart> cartList = cartService.getAllCarts();
        Cart cart = cartList.get(0);
        if(cart != null){
            Cart cart2 = cartService.getCartById(1L);
            Assertions.assertThat(cart2.getId()).isEqualTo(1L);
        }
    }
}
