package com.shopping_cart.eshoppers.controller;

/*
 ** 2024, July 18, Thursday, 7:59 AM
 */

import com.shopping_cart.eshoppers.entity.User;
import com.shopping_cart.eshoppers.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUserList(Model model) {
        System.out.println(getClass().getSimpleName());
        List<User> userList = userService.findAll();
//        System.out.println(userList);
        model.addAttribute("userList", userList);
        return "userList";
    }
}
