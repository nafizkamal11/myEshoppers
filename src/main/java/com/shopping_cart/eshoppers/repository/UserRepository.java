package com.shopping_cart.eshoppers.repository;

import com.shopping_cart.eshoppers.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*
 ** 2024, July 16, Tuesday, 3:50 PM
 */

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserName(String username);

    User findByEmail(String email);
}
