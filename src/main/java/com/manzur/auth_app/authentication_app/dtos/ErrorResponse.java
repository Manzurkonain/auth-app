package com.manzur.auth_app.authentication_app.dtos;
import org.springframework.http.HttpStatus;

public record ErrorResponse(
        String message,
        HttpStatus status

) {
}