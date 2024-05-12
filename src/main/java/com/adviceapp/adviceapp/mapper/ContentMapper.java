package com.adviceapp.adviceapp.mapper;

import com.adviceapp.adviceapp.dto.ContentDto;
import com.adviceapp.adviceapp.entity.Content;
import lombok.Data;

@Data
public class ContentMapper {

    public static ContentDto mapToContentDto(Content content) {
        if (content == null) {
            return null;
        }
        return new ContentDto(
                content.getId(),
                content.getType(),
                content.getTitle(),
                content.getDescription(),
                content.getDuration(),
                content.getId()
        );
    }

    public static Content mapToContent(ContentDto contentDto) {
        if (contentDto == null) {
            return null;
        }

        Content content = new Content();
        content.setId(contentDto.getId());
        content.setType(contentDto.getType());
        content.setTitle(contentDto.getTitle());
        content.setDuration(contentDto.getDuration());
        content.getCategory().setId(contentDto.getId());

        return content;
    }

}
