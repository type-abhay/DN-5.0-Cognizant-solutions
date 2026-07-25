package com.cognizant.jwt_authentication_service.controller;

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
        LOGGER.debug("Authorization Header : {}", authHeader);


        // Creating response map
        Map<String, String> map = new HashMap<>();


        // Extract username from Authorization header
        String user = getUser(authHeader);

        LOGGER.debug("User extracted : {}", user);
        
        // Generate JWT token using username
        String token = generateJwt(user);

        LOGGER.debug("Generated Token : {}", token);

        map.put("token", token);

        LOGGER.info("END");

        return map;
    }

    private String getUser(String authHeader) {

        LOGGER.debug("START getUser");

        // Remove "Basic " prefix
        String encodedCredentials = authHeader.substring(6);

        LOGGER.debug("Encoded Credentials : {}", encodedCredentials);

        // Decode Base64 credentials
        byte[] decodedBytes =
                Base64.getDecoder().decode(encodedCredentials);

        String decodedString = new String(decodedBytes);

        LOGGER.debug("Decoded String : {}", decodedString);

        // user:pwd -> user
        String user = decodedString.split(":")[0];

        LOGGER.debug("Extracted User : {}", user);
        LOGGER.debug("END getUser");

        return user;
    }

    private String generateJwt(String user) {

        LOGGER.debug("START generateJwt");

        // Secret key for signing JWT
        SecretKey key = Keys.hmacShaKeyFor(
                "secretkeysecretkeysecretkey12345".getBytes());

        String token = Jwts.builder()
                .subject(user)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1200000))
                .signWith(key)
                .compact();

        LOGGER.debug("END generateJwt");

        return token;
    }
}