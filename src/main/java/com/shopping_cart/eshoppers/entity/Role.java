package com.shopping_cart.eshoppers.entity;

/*
 ** 2024, July 18, Thursday, 6:47 AM
 */

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToMany(fetch = FetchType.EAGER/*, mappedBy = "roleList"*/)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "roles_id"),
            inverseJoinColumns = @JoinColumn(name = "users_id")
    )
    private List<User> userList;

    public Role(String name) {
        this.name = name;
    }
}
