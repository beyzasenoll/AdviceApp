package com.adviceapp.adviceapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContentDto {

    private Long id;
    private String type;
    private String title;
    private String description;
    private Double duration;
    private Long categoryID;
}
