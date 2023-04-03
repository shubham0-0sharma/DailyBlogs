package com.noobdev.dailyblog.dailyblog.services;

import com.noobdev.dailyblog.dailyblog.payloads.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user );
    UserDto updateUser(UserDto user, int id);
    UserDto getUserById(int id);
    List<UserDto> getAllUsers();
    void deleteUser (int id);

}
