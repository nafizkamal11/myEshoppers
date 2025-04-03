package com.shopping_cart.eshoppers.service;

import com.shopping_cart.eshoppers.entity.User;
import com.shopping_cart.eshoppers.dto.UserDTO;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

/*
 ** 2024, July 16, Tuesday, 3:26 PM
 */
public interface UserService extends UserDetailsService {
    void saveUser(UserDTO userDTO);

    User findByUserName(String userName);

    User findByEmail(String email);

    List<User> findAll();
}
