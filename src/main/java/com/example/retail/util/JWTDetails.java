package com.example.retail.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class JWTDetails {

    @Autowired
    JwtUtil jwtUtil;

    public String userName(HttpServletRequest request) {
        // Get authorization header and find current user
        final String authorizationHeader = request.getHeader("Authorization");
        String jwt = authorizationHeader.substring(7);
        return jwtUtil.extractUsername(jwt);
    }
}
