package com.adviceapp.adviceapp.dto;

import lombok.*;

import java.util.List;

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
    private JobDto job;
    private List<Long> contentIds;

}
