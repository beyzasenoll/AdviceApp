package com.adviceapp.adviceapp.service;

import com.adviceapp.adviceapp.dto.ContentDto;

import java.util.List;

public interface ContentService {
    ContentDto createContent(ContentDto contentDto);

    ContentDto getContentById(Long content);

    List<ContentDto> gelAllContents();

    ContentDto updateContent(Long contentId, ContentDto updateContent);

    void deleteContent(Long contentId);
}
