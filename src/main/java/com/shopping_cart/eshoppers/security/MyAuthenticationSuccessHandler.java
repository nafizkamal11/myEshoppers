package com.shopping_cart.eshoppers.security;

import com.shopping_cart.eshoppers.entity.User;
import com.shopping_cart.eshoppers.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

/*
 ** 2024, July 18, Thursday, 5:19 AM
 */

@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private UserService userService;

    public MyAuthenticationSuccessHandler(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        HttpSession httpSession = request.getSession();
        String authenticationName = authentication.getName();
        User repositoryName = userService.findByUserName(authenticationName);
        httpSession.setAttribute("user", repositoryName);
        response.sendRedirect(request.getContextPath()+"/eshoppers/home");
    }
}
