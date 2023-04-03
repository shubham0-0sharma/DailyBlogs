package com.noobdev.dailyblog.dailyblog.controllers;

import com.noobdev.dailyblog.dailyblog.payloads.UserDto;
import com.noobdev.dailyblog.dailyblog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/")
    public ResponseEntity<UserDto> createUser (@RequestBody UserDto user){
       UserDto createdUser =  this.userService.createUser(user);

        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);

    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable int id)
    {
        UserDto user = this.userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getUser()
    {
        List<UserDto> users = this.userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @PostMapping("/update/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable int id, @RequestBody UserDto user)
    {
        UserDto updatedUser=this.userService.updateUser(user,id);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable int id){
        this.userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
