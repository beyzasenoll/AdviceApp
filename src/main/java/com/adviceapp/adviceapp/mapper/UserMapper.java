package com.adviceapp.adviceapp.mapper;

import com.adviceapp.adviceapp.dto.UserDto;
import com.adviceapp.adviceapp.dto.UserInterestDto;
import com.adviceapp.adviceapp.entity.User;
import com.adviceapp.adviceapp.entity.UserInterest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class UserMapper {
    public static UserDto mapToUserDto(User user) {
        Set<UserInterestDto> userInterestsDtoSet = mapUserInterestsToDto(user.getUserInterests());
        return new UserDto(
                user.getUser_id(),
                user.getUser_name(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                user.getPhone_num(),
                userInterestsDtoSet
        );
    }

    public static User mapToUser(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getUser_name(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getPassword(),
                userDto.getPhone_num(),
                mapDtoToUserInterests(userDto.getUserInterests())
        );
    }

    private static Set<UserInterestDto> mapUserInterestsToDto(Set<UserInterest> userInterests) {
        return userInterests.stream()
                .map(interest -> new UserInterestDto(interest.getId(), interest.getName()))
                .collect(Collectors.toSet());
    }

    private static Set<UserInterest> mapDtoToUserInterests(Set<UserInterestDto> userInterestsDto) {
        return userInterestsDto.stream()
                .map(dto -> new UserInterest(dto.getId(), dto.getName()))
                .collect(Collectors.toSet());
    }
}
