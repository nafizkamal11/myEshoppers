package com.shopping_cart.eshoppers.repository;

import com.shopping_cart.eshoppers.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 ** 2024, July 18, Thursday, 9:17 AM
 */

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
