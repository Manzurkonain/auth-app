package com.manzur.auth_app.authentication_app.dtos;

public record  LoginRequest(
        String email,
        String password
) {
}