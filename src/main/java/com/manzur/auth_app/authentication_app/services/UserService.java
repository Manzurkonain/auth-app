package com.manzur.auth_app.authentication_app.services;

import com.manzur.auth_app.authentication_app.dtos.UserDTO;

public interface UserService {

    UserDTO createUser(UserDTO UserDTO);

    UserDTO getUserByEmail(String email);

    UserDTO updateUser(UserDTO UserDTO, String userId);

    void deleteUser(String userId);

    UserDTO getUserById(String userId);

    Iterable<UserDTO> getAllUsers();

}