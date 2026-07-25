package com.cognizant.spring_learn.controller;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(
            @RequestHeader("Authorization") String authHeader) {

        LOGGER.info("START");
        LOGGER.debug(authHeader);

        String user = getUser(authHeader);
        LOGGER.debug("User: {}", user);

        Map<String, String> map = new HashMap<>();

        String token = generateJwt(user);

        map.put("token", token);

        LOGGER.info("END");

        return map;
    }

    private String getUser(String authHeader) {

        String encodedCredentials =
                authHeader.substring("Basic ".length());

        byte[] decodedBytes =
                Base64.getDecoder().decode(encodedCredentials);

        String credentials = new String(decodedBytes);

        String user = credentials.split(":")[0];

        return user;
    }

    private String generateJwt(String user) {

        SecretKey key = Keys.hmacShaKeyFor(
                "secretkeysecretkeysecretkey12345"
                        .getBytes(StandardCharsets.UTF_8)
        );

        String token = Jwts.builder()
                .subject(user)
                .issuedAt(new Date())
                .expiration(
                        new Date(System.currentTimeMillis() + 1200000)
                )
                .signWith(key)
                .compact();

        return token;
    }
}