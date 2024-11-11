package com.runtally.runtally.auth;

import com.runtally.runtally.services.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

//@Service
public class BasicAuthFilterService extends OncePerRequestFilter {

    private final UserService userService;

    public BasicAuthFilterService(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        System.out.println(userService.getUsers());


        filterChain.doFilter(request, response);
    }
}
