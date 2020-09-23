package com.example.smarthome.account;

public interface JwtServiceHolder {
    void saveJWTToken(String token);
    String getToken();
    void removeToken();
}