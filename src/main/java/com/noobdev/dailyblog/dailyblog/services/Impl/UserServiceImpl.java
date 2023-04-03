package com.noobdev.dailyblog.dailyblog.services.Impl;

import com.noobdev.dailyblog.dailyblog.exceptions.ResourceNotFoundException;
import com.noobdev.dailyblog.dailyblog.models.User;
import com.noobdev.dailyblog.dailyblog.payloads.UserDto;
import com.noobdev.dailyblog.dailyblog.repositories.UserRepository;
import com.noobdev.dailyblog.dailyblog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = userDtoToUser(userDto);
       User savedUser  = this.userRepository.save(user);
       return userToUserDto(savedUser);


    }

    @Override
    public UserDto updateUser(UserDto userDto, int userId) {

        User foundUser=  this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        foundUser.setName(userDtoToUser(userDto).getName());
        foundUser.setEmail(userDtoToUser(userDto).getEmail());
        foundUser.setPassword(userDtoToUser(userDto).getPassword());
        foundUser.setAbout(userDtoToUser(userDto).getAbout());
        return  userToUserDto(foundUser) ;
    }

    @Override
    public UserDto getUserById(int userId) {
        User foundUser=  this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        return userToUserDto(foundUser);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> this.userToUserDto(user)).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(int id) {
        this.userRepository.deleteById(id);


    }

    private User userDtoToUser(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        return user;
    }
    private UserDto userToUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setAbout(user.getAbout());
        return userDto;
    }
}
