package com.securitydemo.config;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    public SuccessHandler() {
        System.out.println(getClass().getSimpleName());
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws ServletException, IOException {

        boolean isAdmin = authentication.getAuthorities()
                .stream().anyMatch(granted -> granted.getAuthority().equals("ROLE_ADMIN"));

        if (isAdmin) {
            System.out.println("admin login");
            setDefaultTargetUrl("/admin/home");
        } else {
            System.out.println("user login");
            setDefaultTargetUrl("/user/home");
        }

        super.onAuthenticationSuccess(request, response, authentication);
    }

}