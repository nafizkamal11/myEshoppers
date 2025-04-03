package com.shopping_cart.eshoppers.repository;

import com.shopping_cart.eshoppers.dto.ProductDTO;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/*
 ** 2024, July 15, Monday, 5:58 PM
 */

@Repository
public class DummyProductRepositoryImpl implements ProductRepository{
    public static List<ProductDTO> productDTOList = new ArrayList<>();
    static {
        productDTOList.add(new ProductDTO("Headphones", "Jabra Elite Bluetooth Headphones", BigDecimal.valueOf(249.99)));
        productDTOList.add(new ProductDTO("Apple iPad", "Apple iPad 10.2 32GB", BigDecimal.valueOf(369.99)));
        productDTOList.add(new ProductDTO("Laptop", "Apple Laptop", BigDecimal.valueOf(999.99)));
    }

    @Override
    public List<ProductDTO> findAllProducts() {
        return productDTOList;
    }
}
