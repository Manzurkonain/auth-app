package com.manzur.auth_app.authentication_app.services;

import com.manzur.auth_app.authentication_app.dtos.UserDTO;

public interface AuthService {

    UserDTO register(UserDTO userDTO);
}
