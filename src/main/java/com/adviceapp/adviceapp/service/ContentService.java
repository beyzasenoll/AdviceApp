package com.adviceapp.adviceapp.service;

import com.adviceapp.adviceapp.dto.ContentDto;
import com.adviceapp.adviceapp.entity.Content;
import jakarta.transaction.Transactional;

import java.util.List;

public interface ContentService {
    ContentDto createContent(ContentDto contentDto);

    ContentDto getContentById(Long content);

    List<ContentDto> gelAllContents();

    ContentDto updateContent(Long contentId, ContentDto updateContent);

    void deleteContent(Long contentId);

}
