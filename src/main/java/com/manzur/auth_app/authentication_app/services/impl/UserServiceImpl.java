package com.manzur.auth_app.authentication_app.services.impl;

import com.manzur.auth_app.authentication_app.dtos.UserDTO;
import com.manzur.auth_app.authentication_app.entities.Provider;
import com.manzur.auth_app.authentication_app.entities.Role;
import com.manzur.auth_app.authentication_app.entities.User;
import com.manzur.auth_app.authentication_app.exceptions.ResourceNotFoundException;
import com.manzur.auth_app.authentication_app.helper.UserHelper;
import com.manzur.auth_app.authentication_app.repositories.UserRepository;
import com.manzur.auth_app.authentication_app.services.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.HashSet;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

//    private final RoleRepository roleRepository;

    @Override
    @Transactional
    public UserDTO createUser(UserDTO UserDTO) {
        if (UserDTO.getEmail() == null || UserDTO.getEmail().isBlank()) {
            throw new IllegalArgumentException("Email is required");
        }
        if (userRepository.existsByEmail(UserDTO.getEmail())) {
            throw new IllegalArgumentException("User with given email already exists");
        }

        User user = modelMapper.map(UserDTO, User.class);
        user.setProvider(UserDTO.getProvider() != null ? UserDTO.getProvider() : Provider.LOCAL);
        if (user.getRoles() == null) {
            user.setRoles(new HashSet<>());
        }
        //role assign here to user___for authorization
        //TODO:
        //assign the default role
//
//        Role role = roleRepository.findByName("ROLE_" + AppConstants.GUEST_ROLE).orElse(null);
//        user.getRoles().add(role);





        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserDTO.class);
    }

    @Override
    public UserDTO getUserByEmail(String email) {

        User user = userRepository
                .findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with given email id "));
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public UserDTO updateUser(UserDTO UserDTO, String userId) {
        UUID uId = UserHelper.parseUUID(userId);
        User existingUser = userRepository
                .findById(uId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with given id"));
        //email id can not be updated.
        if (UserDTO.getName() != null) existingUser.setName(UserDTO.getName());
        if (UserDTO.getImage() != null) existingUser.setImage(UserDTO.getImage());
        if (UserDTO.getProvider() != null) existingUser.setProvider(UserDTO.getProvider());
        //TODO: change password update logic...
        if (UserDTO.getPassword() != null) existingUser.setPassword(UserDTO.getPassword());
        existingUser.setEnable(UserDTO.isEnable());
        existingUser.setUpdatedAt(Instant.now());
        User updatedUser = userRepository.save(existingUser);
        return modelMapper.map(updatedUser, UserDTO.class);
    }

    @Override
    public void deleteUser(String userId) {
        UUID uId = UserHelper.parseUUID(userId);
        User user = userRepository.findById(uId).orElseThrow(() -> new ResourceNotFoundException("User not found with given id"));
        userRepository.delete(user);
    }

    @Override
    public UserDTO getUserById(String userId) {
        User user = userRepository.findById(UserHelper.parseUUID(userId)).orElseThrow(() -> new ResourceNotFoundException("User not found with given id"));
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    @Transactional
    public Iterable<UserDTO> getAllUsers() {
        return userRepository
                .findAll()
                .stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .toList();
    }
}
