package com.manzur.auth_app.authentication_app.services.impl;

import com.manzur.auth_app.authentication_app.dtos.UserDTO;
import com.manzur.auth_app.authentication_app.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserDTO createUser(UserDTO UserDTO) {
        return null;
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        return null;
    }

    @Override
    public UserDTO updateUser(UserDTO UserDTO, String userId) {
        return null;
    }

    @Override
    public void deleteUser(String userId) {

    }

    @Override
    public UserDTO getUserById(String userId) {
        return null;
    }

    @Override
    public Iterable<UserDTO> getAllUsers() {
        return null;
    }
}
