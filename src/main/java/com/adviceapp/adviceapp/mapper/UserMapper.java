package com.adviceapp.adviceapp.mapper;

import com.adviceapp.adviceapp.dto.UserDto;
import com.adviceapp.adviceapp.entity.User;
import lombok.Data;

@Data
public class UserMapper {
    public static UserDto mapToUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getUser_name(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                user.getPhone_num());
    }


    public static User mapToUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setUser_name(userDto.getUser_name());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setPhone_num(userDto.getPhone_num());
        return user;
    }

}
