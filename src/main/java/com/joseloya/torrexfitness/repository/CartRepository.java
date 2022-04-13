package com.joseloya.torrexfitness.repository;

import com.joseloya.torrexfitness.model.Cart;
import com.joseloya.torrexfitness.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{

}