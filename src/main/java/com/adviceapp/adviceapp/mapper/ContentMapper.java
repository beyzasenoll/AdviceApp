package com.adviceapp.adviceapp.mapper;

import com.adviceapp.adviceapp.dto.ContentDto;
import com.adviceapp.adviceapp.entity.Category;
import com.adviceapp.adviceapp.entity.Content;
import com.adviceapp.adviceapp.entity.Platform;
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
                content.getCategory().getId(),
                content.getPlatform().getPlatform_id(),
                content.getLink()
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
        if (content.getCategory() == null) {
            content.setCategory(new Category());
        }
        content.getCategory().setId(contentDto.getCategoryID());

        // Initialize platform if null
        if (content.getPlatform() == null) {
            content.setPlatform(new Platform());
        }
        content.getPlatform().setPlatform_id(contentDto.getPlatformId());
        content.setLink(contentDto.getLink());

        return content;

    }

}
