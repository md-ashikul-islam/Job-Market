package com.ashik.jobmarket.controller;

import com.ashik.jobmarket.payloads.UserDTO;
import com.ashik.jobmarket.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    //Create User API
    @PostMapping("/")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        UserDTO createdUserDTO=this.userService.createUser(userDTO);
        return new ResponseEntity<>(createdUserDTO, HttpStatus.CREATED);
    }

    //Update User Api
    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO,@PathVariable int userId){
        UserDTO updateUser= this.userService.updateUser(userDTO,userId);
        return ResponseEntity.ok(updateUser);
    }

    //DeleteUser
}
