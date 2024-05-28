package com.adviceapp.adviceapp.controller;

import com.adviceapp.adviceapp.dto.JobDto;
import com.adviceapp.adviceapp.dto.UserDto;
import com.adviceapp.adviceapp.entity.Job;
import com.adviceapp.adviceapp.entity.User;
import com.adviceapp.adviceapp.mapper.UserMapper;
import com.adviceapp.adviceapp.repository.JobRepository;
import com.adviceapp.adviceapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {
    private UserService userService;
    private JobRepository jobRepository;

    @PostMapping("/newUser")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto savedUserDto = userService.createUser(userDto);
        return new ResponseEntity<>(savedUserDto, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserbyId(@PathVariable("id") Long userId) {
        UserDto userDto = userService.getUserById(userId);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getALlUsers() {
        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId,
                                                  @RequestBody UserDto updatedUSer) {
        UserDto employeeDto = userService.updateUser(userId, updatedUSer);
        return ResponseEntity.ok(employeeDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("User deleted succesfully!");
    }
    @PostMapping("/login")
    public ResponseEntity<UserDto> authenticateUser(@RequestBody UserDto userDto) {
        UserDto authenticatedUser = userService.authenticateUser(userDto.getEmail(), userDto.getPassword());
        if (authenticatedUser != null) {
            return ResponseEntity.ok(authenticatedUser);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
