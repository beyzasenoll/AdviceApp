package com.adviceapp.adviceapp.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserInterestDto {
    private Long id;
    private String name;
    private Long userId;
    private Long categoryId;
    private boolean availability;

    public UserInterestDto(Long id, String name) {
    }
}
