package com.ashik.jobmarket.security;

import com.ashik.jobmarket.exceptions.ResourceNotFoundException;
import com.ashik.jobmarket.model.User;
import com.ashik.jobmarket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        //Load user from DATABASE by Username
        User user = this.userRepository.findByEmail(email).orElseThrow(()->new ResourceNotFoundException("user ","email: "+email,0 ));

        return user;
    }
}
