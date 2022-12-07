package com.ashik.jobmarket.services.implementation;

import com.ashik.jobmarket.exceptions.ResourceNotFoundException;
import com.ashik.jobmarket.model.User;
import com.ashik.jobmarket.payloads.UserDTO;
import com.ashik.jobmarket.repository.UserRepository;
import com.ashik.jobmarket.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user =this.dtoToUser(userDTO);
        User savedUser = this.userRepo.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDTO updateUser(UserDTO uDto, int userId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User", "ID",userId));

        user.setName(uDto.getName());
        user.setEmail(uDto.getEmail());
        user.setPassword(uDto.getPassword());
        User updatedUser = this.userRepo.save(user);
        return userToDto(updatedUser);
    }

    @Override
    public UserDTO getUserById(int userId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User", "ID",userId));
        return userToDto(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users= this.userRepo.findAll();
        List<UserDTO> userDtos= users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public void deleteUser(int userId) {

        User user = this.userRepo.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User", "ID",userId));

        this.userRepo.delete(user);
    }

    private User dtoToUser(UserDTO uDto){
        User user= new User();
        user.setId(uDto.getId());
        user.setName(uDto.getName());;
        user.setEmail(uDto.getEmail());
        user.setPassword(uDto.getPassword());

        return user;
    }

    private UserDTO userToDto(User user){
        UserDTO uDto = new UserDTO();
        uDto.setId(user.getId());
        uDto.setName(user.getName());
        uDto.setEmail(user.getEmail());
        uDto.setPassword(user.getPassword());

        return uDto;
    }
}
