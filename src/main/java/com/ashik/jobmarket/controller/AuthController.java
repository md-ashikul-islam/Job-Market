package com.ashik.jobmarket.controller;

import com.ashik.jobmarket.exceptions.ApiException;
import com.ashik.jobmarket.model.User;
import com.ashik.jobmarket.payloads.JwtAuthRequest;
import com.ashik.jobmarket.payloads.JwtAuthResponse;
import com.ashik.jobmarket.payloads.UserDTO;
import com.ashik.jobmarket.repository.UserRepository;
import com.ashik.jobmarket.security.JwtTokenHelper;
import com.ashik.jobmarket.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/api/v1/auth/")
public class AuthController {

    @Autowired
    private JwtTokenHelper jwtTokenHelper;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request) throws Exception {
        this.authenticate(request.getUsername(), request.getPassword());
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUsername());
        String token = this.jwtTokenHelper.generateToken(userDetails);

        JwtAuthResponse response = new JwtAuthResponse();
        response.setToken(token);
        response.setUser(this.mapper.map((User) userDetails, UserDTO.class));
        return new ResponseEntity<JwtAuthResponse>(response, HttpStatus.OK);
    }

    private void authenticate(String username, String password) throws Exception {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,
                password);

        try {

            this.authenticationManager.authenticate(authenticationToken);

        } catch (BadCredentialsException e) {
            System.out.println("Invalid Details !!");
            throw new ApiException("Invalid username or password !!");
        }

    }

    // register new user api

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@Valid @RequestBody UserDTO userDto) {
        UserDTO registeredUser = this.userService.registerNewUser(userDto);
        return new ResponseEntity<UserDTO>(registeredUser, HttpStatus.CREATED);
    }

    // get loggedin user data
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper mapper;

    @GetMapping("/current-user/")
    public ResponseEntity<UserDTO> getUser(Principal principal) {
        User user = this.userRepository.findByEmail(principal.getName()).get();
        return new ResponseEntity<UserDTO>(this.mapper.map(user, UserDTO.class), HttpStatus.OK);
    }

}