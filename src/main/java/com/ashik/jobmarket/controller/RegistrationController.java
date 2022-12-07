//package com.ashik.jobmarket.controller;
//
//
//import com.ashik.jobmarket.model.User;
//import com.ashik.jobmarket.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@CrossOrigin(origins = "http://localhost:3000")
//public class RegistrationController {
//    @Autowired
//    UserRepository userRepo;
//
//    @PostMapping("/addUser")
//    @CrossOrigin
//    public User addUser(@RequestBody User user){
//        return userRepo.save(user);
//    }
//
//
//
//}
