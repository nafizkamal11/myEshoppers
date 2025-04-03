package com.shopping_cart.eshoppers.dto;

/*
 ** 2024, July 16, Tuesday, 3:09 PM
 */

import com.shopping_cart.eshoppers.dto.myAnnotation.PasswordMatcher;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
//@PasswordMatcher(first="password", second="passwordConfirm")
public class UserDTO {
    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String email;

    @NotNull
    @Size(min = 3, message = "min=3, is required!")
    private String userName;

    @NotNull
    private String password;

//    @NotNull
//    private String passwordConfirm;

    public UserDTO(String firstName, String lastName, String email, String userName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
    }
}
