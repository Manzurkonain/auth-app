package com.manzur.auth_app.authentication_app.controllers;

import com.manzur.auth_app.authentication_app.dtos.UserDTO;
import com.manzur.auth_app.authentication_app.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    //create user api
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO UserDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(UserDTO));
    }

    // get all user api
    @GetMapping
    public ResponseEntity<Iterable<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // get user by email
    @GetMapping("/email/{email}")
    public ResponseEntity<UserDTO> getUserByEmail(@PathVariable("email") String email) {
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }

    //delete user
    //api/v1/users/{userId}
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") String userId) {
        userService.deleteUser(userId);
    }

    //update user
    //api/v1/users/{userId}
    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO UserDTO, @PathVariable("userId") String userId) {
        return ResponseEntity.ok(userService.updateUser(UserDTO, userId));
    }

    //get user by id
    //api/v1/users/{userId}
//    @PreAuthorize("hasRole('"+ AppConstants.ADMIN_ROLE +"')")
    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("userId") String userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }
}
