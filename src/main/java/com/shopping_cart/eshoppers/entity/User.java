package com.shopping_cart.eshoppers.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/*
 ** 2024, July 17, Wednesday, 3:14 AM
 */

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userName;
    private String password;
    private boolean enabled;

    private String firstName;
    private String lastName;
    private String email;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id")
    )
    private List<Role> roleList;
}
