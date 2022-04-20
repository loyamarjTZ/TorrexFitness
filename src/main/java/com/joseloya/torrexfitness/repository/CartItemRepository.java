package com.joseloya.torrexfitness.repository;

import com.joseloya.torrexfitness.model.CartItem;
import com.joseloya.torrexfitness.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}
