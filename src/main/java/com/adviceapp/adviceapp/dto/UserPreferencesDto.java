package com.adviceapp.adviceapp.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserPreferencesDto {
    private Long userId;
    private Long categoryId;
    private Double availabilityDuration;
}
