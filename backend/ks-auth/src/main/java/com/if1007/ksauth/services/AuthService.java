package com.if1007.ksauth.services;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthService {

    @Value("${STRATEEGIA_API_URL}")
    private String API_URL;
    @Autowired
    private RestTemplate restTemplate;

    public String authenticate(String email, String password) {

        String originalInput = email+":"+password;
        String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
        String url = "https://api.strateegia.digital/users/v1/auth/signin";

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();

        headers.add("Authorization", "Basic " + encodedString);
        headers.add("Content-Type", "application/json");

        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<String> responseEntity = restTemplate
                .exchange(url, HttpMethod.POST, request, String.class);

        return responseEntity.getBody();
    }
}