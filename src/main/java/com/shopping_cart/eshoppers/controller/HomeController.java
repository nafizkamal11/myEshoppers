package com.shopping_cart.eshoppers.controller;

/*
 ** 2024, July 15, Monday, 2:34 PM
 */

import com.shopping_cart.eshoppers.entity.User;
import com.shopping_cart.eshoppers.dto.ProductDTO;
import com.shopping_cart.eshoppers.service.ProductService;
import com.shopping_cart.eshoppers.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/eshoppers")
public class HomeController {
    private ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/home")
    public String findAllProductSortedByName(Model model) {
        List<ProductDTO> productList = productService.findAllProductSortedByName();
        model.addAttribute("productList", productList);
        return "home";
    }
}
