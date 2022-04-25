package com.joseloya.torrexfitness.service;

import com.joseloya.torrexfitness.model.Cart;
import com.joseloya.torrexfitness.model.CartItem;
import com.joseloya.torrexfitness.service.CartItemService;
import com.joseloya.torrexfitness.service.CartService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CartItemServiceImplTest {

    @Autowired
    private CartItemService cartItemService;

    @Test
    public void should_return_true_when_at_least_one_cart_item_exists_in_DB(){
        List<CartItem> cartItemList = cartItemService.getAllCartItems();
        CartItem cartItem1 = cartItemList.get(0);
        if(cartItem1 != null){
            CartItem cartItem2 = cartItemService.getCartItemById(1L);
            Assertions.assertThat(cartItem2.getId()).isEqualTo(1L);
        }
    }
}
