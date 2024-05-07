package com.adviceapp.adviceapp.mapper;

import com.adviceapp.adviceapp.dto.ContentDto;
import com.adviceapp.adviceapp.entity.Category;
import com.adviceapp.adviceapp.entity.Content;
import com.adviceapp.adviceapp.entity.Platform;

public class ContentMapper {

    public static ContentDto mapToContentDto(Content content) {
        if (content == null) {
            return null;
        }
        return new ContentDto(
                content.getContent_id(),
                content.getContentType(),
                content.getContentName(),
                content.getContentDuration(),
                content.getCategory() != null ? content.getCategory().getCategory_id() : null,
                content.getPlatform() != null ? content.getPlatform().getPlatform_id() : null
        );
    }

    public static Content mapToContent(ContentDto contentDto) {
        if (contentDto == null) {
            return null;
        }

        Content content = new Content();
        content.setContent_id(contentDto.getContent_id());
        content.setContentType(contentDto.getContentType());
        content.setContentName(contentDto.getContentName());
        content.setContentDuration(contentDto.getContentDuration());

        if (contentDto.getCategoryId() != null) {
            Category category = new Category();
            category.setCategory_id(contentDto.getCategoryId());
            content.setCategory(category);
        }

        if (contentDto.getPlatformId() != null) {
            Platform platform = new Platform();
            platform.setPlatform_id(contentDto.getPlatformId());
            content.setPlatform(platform);
        }

        return content;
    }

}
