package com.adviceapp.adviceapp.service.impl;

import com.adviceapp.adviceapp.dto.UserDto;
import com.adviceapp.adviceapp.entity.Job;
import com.adviceapp.adviceapp.entity.User;
import com.adviceapp.adviceapp.exception.ResourceNotFoundException;
import com.adviceapp.adviceapp.mapper.UserMapper;
import com.adviceapp.adviceapp.repository.JobRepository;
import com.adviceapp.adviceapp.repository.UserRepository;
import com.adviceapp.adviceapp.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Data
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private JobRepository jobRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);

        if (userDto.getJob() != null && userDto.getJob().getId() != null) {
            Job job = jobRepository.findById(userDto.getJob().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Job not found with id: " + userDto.getJob().getId()));
            user.setJob(job);
        }

        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }


    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("User is not exist with a given id : + userId"));
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> UserMapper.mapToUserDto(user)).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long userId, UserDto updatedUser) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User is not exists with given id: \" + userID")
        );
        user.setUser_name(updatedUser.getUser_name());
        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setEmail(updatedUser.getEmail());
        user.setPhone_num(updatedUser.getPhone_num());

        User updatedUserObj = userRepository.save(user);
        return UserMapper.mapToUserDto(updatedUserObj);
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User is not exists with given id: " + userId)
        );
        userRepository.deleteById(userId);
    }
    @Override
    public UserDto authenticateUser(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmailAndPassword(email, password);
        return userOptional.map(UserMapper::mapToUserDto).orElse(null);
    }
}
