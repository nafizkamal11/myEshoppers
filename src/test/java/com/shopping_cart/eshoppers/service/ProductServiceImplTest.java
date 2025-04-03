package com.shopping_cart.eshoppers.service;

/*
 ** 2024, July 15, Monday, 3:20 PM
 */

import com.shopping_cart.eshoppers.dto.ProductDTO;
import com.shopping_cart.eshoppers.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductServiceImplTest {
    private ProductDTO HEADPHONES = new ProductDTO("Headphones", "Jabra Elite Bluetooth Headphones", BigDecimal.valueOf(369.99));
    private ProductDTO APPLE_I_PAD = new ProductDTO("Apple iPad", "Apple iPad 10.2 32GB", BigDecimal.valueOf(369.99));

    private ProductRepository productRepository;
    private ProductService productService;

    @BeforeEach
    public void setUp() throws Exception{
        productRepository = mock(ProductRepository.class);
        productService = new ProductServiceImpl(productRepository);
    }

    @Test
    public void testFindAllProductSortedByName() {
        when(productRepository.findAllProducts())
                .thenReturn(List.of(HEADPHONES,APPLE_I_PAD));

        List<ProductDTO> sortedByName = productService.findAllProductSortedByName();
        Assertions.assertEquals(APPLE_I_PAD.getProductName(), sortedByName.get(0).getProductName());
        Assertions.assertEquals(HEADPHONES.getProductName(), sortedByName.get(1).getProductName());
    }
}
