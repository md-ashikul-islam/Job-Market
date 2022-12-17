package com.ashik.jobmarket.services;

import com.ashik.jobmarket.payloads.UserDTO;
import java.util.List;
public interface UserService {

    UserDTO registerNewUser(UserDTO user);

    UserDTO createUser(UserDTO user);
    UserDTO updateUser(UserDTO user, Integer userId);
    UserDTO getUserById(Integer userId);
    List<UserDTO> getAllUsers();
    void deleteUser(Integer userId);

}
