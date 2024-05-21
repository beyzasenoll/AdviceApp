package com.adviceapp.adviceapp.service;

import com.adviceapp.adviceapp.dto.UserDto;

import java.util.List;


/*public UserDto createUser(UserDto userDto) {
    User user = //dto to domain object mapper
    Department savedDepartment = departmentRepository.save(department);
    return DepartmentMapper.mapToDepartmentDto(savedDepartment);
}*/
public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUserById(Long user);

    List<UserDto> getAllUsers();

    UserDto updateUser(Long userId, UserDto updateUser);

    void deleteUser(Long userId);
}
