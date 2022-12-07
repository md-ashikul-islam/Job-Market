//package com.ashik.jobmarket.controller;
//
//import com.ashik.jobmarket.model.User;
//import com.ashik.jobmarket.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@CrossOrigin(origins = "http://localhost:3000")
//public class LoginController {
//    @Autowired
//    UserRepository userRepo;
//    @RequestMapping(value ="/login")
//    public String loginVerify(@RequestParam String email, @RequestParam String password){
//        if(email.equals("ashik@gmail.com") && password.equals("1234")){
//            return "welcome";
//        }
//        System.out.println("Invalid Cred");
//        return "Error";
//    }
//}
