package com.ashik.jobmarket.services.implementation;

import com.ashik.jobmarket.config.AppConstants;
import com.ashik.jobmarket.exceptions.ResourceNotFoundException;
import com.ashik.jobmarket.model.Role;
import com.ashik.jobmarket.model.User;
import com.ashik.jobmarket.payloads.UserDTO;
import com.ashik.jobmarket.repository.RoleRepository;
import com.ashik.jobmarket.repository.UserRepository;
import com.ashik.jobmarket.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user =this.dtoToUser(userDTO);
        User savedUser = this.userRepository.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDTO updateUser(UserDTO uDto, Integer userId) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User", "ID",userId));

        user.setName(uDto.getName());
        user.setEmail(uDto.getEmail());
        user.setPassword(uDto.getPassword());
        User updatedUser = this.userRepository.save(user);
        return userToDto(updatedUser);
    }

    @Override
    public UserDTO getUserById(Integer userId) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User", "ID",userId));
        return userToDto(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users= this.userRepository.findAll();
        List<UserDTO> userDtos= users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public void deleteUser(Integer userId) {

        User user = this.userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User", "ID",userId));

        this.userRepository.delete(user);
    }

    private User dtoToUser(UserDTO uDto){
        User user= this.modelMapper.map(uDto,User.class);
        return user;
    }

    private UserDTO userToDto(User user){
        UserDTO uDto = this.modelMapper.map(user, UserDTO.class);
        return uDto;
    }
    @Override
    public UserDTO registerNewUser(UserDTO userDto) {

        User user = this.modelMapper.map(userDto, User.class);

        // encoded the password
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));

        // roles
        Role role = this.roleRepository.findById(AppConstants.NORMAL_USER).get();

        user.getRoles().add(role);

        User newUser = this.userRepository.save(user);

        return this.modelMapper.map(newUser, UserDTO.class);
    }
}
