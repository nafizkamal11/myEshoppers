package com.shopping_cart.eshoppers.repository;

import com.shopping_cart.eshoppers.dto.ProductDTO;

import java.util.List;

/*
 ** 2024, July 15, Monday, 2:55 PM
 */
public interface ProductRepository {
    List<ProductDTO> findAllProducts();
}
