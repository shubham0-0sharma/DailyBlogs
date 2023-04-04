package com.noobdev.dailyblog.dailyblog.controllers;

import com.noobdev.dailyblog.dailyblog.payloads.ApiResponse;
import com.noobdev.dailyblog.dailyblog.payloads.UserDto;
import com.noobdev.dailyblog.dailyblog.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/")
    public ResponseEntity<UserDto> createUser (@Valid @RequestBody UserDto user){
       UserDto createdUser =  this.userService.createUser(user);

        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);

    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable("id") int uid)
    {
        UserDto user = this.userService.getUserById(uid);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getUser()
    {
        List<UserDto> users = this.userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @PostMapping("/update/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") int uid, @Valid @RequestBody UserDto user)
    {
        UserDto updatedUser=this.userService.updateUser(user,uid);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") int uid){
        this.userService.deleteUser(uid);
        return new  ResponseEntity(new ApiResponse("User Deleted Successfully",true), HttpStatus.OK);

    }

}
