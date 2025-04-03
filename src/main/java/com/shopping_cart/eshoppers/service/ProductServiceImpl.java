package com.shopping_cart.eshoppers.service;

import com.shopping_cart.eshoppers.dto.ProductDTO;
import com.shopping_cart.eshoppers.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

/*
 ** 2024, July 15, Monday, 2:54 PM
 */

@Service
public class ProductServiceImpl implements ProductService{
    private ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProductDTO> findAllProductSortedByName() {
        return repository.findAllProducts()
                .stream()
                .sorted(Comparator.comparing(ProductDTO::getProductName))
                .toList();
    }
}
