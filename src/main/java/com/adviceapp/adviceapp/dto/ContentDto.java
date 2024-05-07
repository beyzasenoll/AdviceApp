package com.adviceapp.adviceapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContentDto {

    private Long content_id;
    private String contentType;
    private String contentName;
    private Double contentDuration;
    private Long categoryId;
    private Long platformId;

}
