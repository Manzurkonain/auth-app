package com.manzur.auth_app.authentication_app.services.impl;

import com.manzur.auth_app.authentication_app.dtos.UserDTO;
import com.manzur.auth_app.authentication_app.services.AuthService;
import com.manzur.auth_app.authentication_app.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
     private final UserService userService;
     private  final PasswordEncoder passwordEncoder;


        @Override
        public UserDTO register(UserDTO UserDTO) {
            //logic
            //verify email
            //verify password
            //default roles

            UserDTO.setPassword(passwordEncoder.encode(UserDTO.getPassword()));
            return userService.createUser(UserDTO);
        }

}
