package com.adviceapp.adviceapp.dto;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private Long id;
    private String user_name;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone_num;
    private Set<UserInterestDto> userInterests = new HashSet<>();}
