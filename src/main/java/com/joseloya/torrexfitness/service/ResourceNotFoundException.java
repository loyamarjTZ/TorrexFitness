package com.joseloya.torrexfitness.service;

public class ResourceNotFoundException extends IllegalArgumentException{
    public ResourceNotFoundException(String product_not_found) {
        System.out.println("Product not found!");
    }
}
