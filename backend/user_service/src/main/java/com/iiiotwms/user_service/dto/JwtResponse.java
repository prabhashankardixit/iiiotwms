package com.iiiotwms.user_service.dto;

public class JwtResponse {
    private String token;

    // Constructor
    public JwtResponse(String token) {
        this.token = token;
    }

    // Getter
    public String getToken() {
        return token;
    }

    // Optional: Setter (if you want mutability)
    public void setToken(String token) {
        this.token = token;
    }
}
