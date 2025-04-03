package com.shopping_cart.eshoppers.controller;

/*
 ** 2024, July 16, Tuesday, 2:18 PM
 */

import com.shopping_cart.eshoppers.dto.UserDTO;
import com.shopping_cart.eshoppers.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class LoginController {
    private UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getLogin(Model model) {
        return "login";
    }
}
