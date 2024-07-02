package com.maen.presentation.controller;

import com.maen.presentation.dto.UserDTO;
import com.maen.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    // Inyectar la interfaz del IUserService para poder utilizar los metodos.
    @Autowired
    private IUserService userService;

    //Find All
    @GetMapping("/find")
    public ResponseEntity<List<UserDTO>> findAll(){
        return new ResponseEntity<>(this.userService.findAll(), HttpStatus.OK);
    }

    //Find by id
    @GetMapping("/find/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
        return new ResponseEntity<>(this.userService.findById(id), HttpStatus.OK);
    }

    //Create user.
    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(this.userService.createUser(userDTO), HttpStatus.CREATED);
    }

    // Update user
    @PutMapping("/update/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO){
        return new ResponseEntity<>(this.userService.updateUser(id, userDTO), HttpStatus.OK);
    }

    // Delete User.
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        return new ResponseEntity<>(this.userService.deleteUser(id), HttpStatus.NO_CONTENT);
    }
}