package com.adviceapp.adviceapp.dto;

import lombok.*;

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
}
