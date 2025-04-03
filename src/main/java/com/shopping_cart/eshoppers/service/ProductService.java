package com.shopping_cart.eshoppers.service;

import com.shopping_cart.eshoppers.dto.ProductDTO;

import java.util.List;

/*
 ** 2024, July 15, Monday, 2:32 PM
 */
public interface ProductService {
    List<ProductDTO> findAllProductSortedByName();
}
