package com.adviceapp.adviceapp.service;

import com.adviceapp.adviceapp.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUserById(Long user);

    List<UserDto> getAllUsers();

    UserDto updateUser(Long userId, UserDto updateUser);

    void deleteUser(Long userId);
    UserDto authenticateUser(String email, String password);

}
