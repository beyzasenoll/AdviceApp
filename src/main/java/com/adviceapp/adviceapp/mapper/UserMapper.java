package com.adviceapp.adviceapp.mapper;

import com.adviceapp.adviceapp.dto.JobDto;
import com.adviceapp.adviceapp.dto.UserDto;
import com.adviceapp.adviceapp.entity.User;
import com.adviceapp.adviceapp.entity.Job;

public class UserMapper {
    public static UserDto mapToUserDto(User user) {
        if (user == null) return null;

        JobDto jobDto = null;
        if (user.getJob() != null) {
            jobDto = new JobDto(user.getJob().getId(), user.getJob().getJob_name());
        }

        return new UserDto(
                user.getId(),
                user.getUser_name(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                user.getPhone_num(),
                jobDto,
                user.getContents().stream().map(x -> x.getId()).toList()
        );
    }

    public static User mapToUser(UserDto userDto) {
        if (userDto == null) return null;

        Job job = null;
        if (userDto.getJob() != null) {
            job = new Job(userDto.getJob().getId(), userDto.getJob().getJob_name(), null);
        }

        User user = new User();
        user.setId(userDto.getId());
        user.setUser_name(userDto.getUser_name());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setPhone_num(userDto.getPhone_num());
        user.setJob(job);

        return user;
    }

    public static Job mapToJob(JobDto jobDto) {
        if (jobDto == null) return null;

        return new Job(jobDto.getId(), jobDto.getJob_name(), null);
    }
}
