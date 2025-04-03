package com.shopping_cart.eshoppers.controller;

/*
 ** 2024, July 16, Tuesday, 2:18 PM
 */

import com.shopping_cart.eshoppers.entity.User;
import com.shopping_cart.eshoppers.dto.UserDTO;
import com.shopping_cart.eshoppers.service.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/signup")
public class SignupController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SignupController.class);

    private UserService userService;

    public SignupController(UserService userService) {
        this.userService = userService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @GetMapping
    public String getSignup(Model model) {
        model.addAttribute("userDTO", new UserDTO("Nafiz", "Kamal", "nafiz.kamal@email.com", "zifan"));
//        model.addAttribute("userDTO", new UserDTO());
        return "signup";
    }

    @PostMapping
    public String postSignup(@Valid @ModelAttribute UserDTO userDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            LOGGER.info("BindingResult : {}", bindingResult);
            return "signup";
        }

        LOGGER.info("saving : {}", userDTO);

        User byUserName = userService.findByUserName(userDTO.getUserName());
//        User byEmail = userService.findByEmail(userDTO.getEmail());
        if (byUserName!=null) {
            LOGGER.info("user already present!");
            model.addAttribute("userDTO", new User());
            model.addAttribute("registrationError", "User name already exists");
            return "signup";
        }

        userService.saveUser(userDTO);
        LOGGER.info("saved : {}", userService.findByUserName(userDTO.getUserName()));

        return "redirect:/eshoppers/home";
    }
}
