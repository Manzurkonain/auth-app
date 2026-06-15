package com.manzur.auth_app.authentication_app.dtos;


public record TokenResponse(
        String accessToken,
        String refreshToken,
        long expiresIn,
        String tokenType,
        UserDTO user
) {

    public static TokenResponse of(String accessToken, String refreshToken, long expiresIn, UserDTO user) {
        return new TokenResponse(accessToken, refreshToken, expiresIn, "Bearer", user);
    }

}
