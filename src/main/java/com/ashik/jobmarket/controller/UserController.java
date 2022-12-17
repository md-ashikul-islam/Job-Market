package com.ashik.jobmarket.controller;

import com.ashik.jobmarket.payloads.ApiResponse;
import com.ashik.jobmarket.payloads.UserDTO;
import com.ashik.jobmarket.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    //Create User API
    @PostMapping("/")
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO){
        UserDTO createdUserDTO=this.userService.createUser(userDTO);
        return new ResponseEntity<>(createdUserDTO, HttpStatus.CREATED);
    }

    //Update User Api
    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDTO,@PathVariable Integer userId){
        UserDTO updateUser= this.userService.updateUser(userDTO,userId);
        return ResponseEntity.ok(updateUser);
    }

    //DeleteUser
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable int userId){
        this.userService.deleteUser(userId);
        return new ResponseEntity(new ApiResponse("User Deleted Successfully",true),HttpStatus.OK);
    }

    //Get All Users
    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        return ResponseEntity.ok(this.userService.getAllUsers());
    }
    //Get Single User
    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUser(@PathVariable int userId){
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }
}
