package com.adviceapp.adviceapp.service.impl;

import com.adviceapp.adviceapp.dto.ContentDto;
import com.adviceapp.adviceapp.entity.Content;
import com.adviceapp.adviceapp.exception.ResourceNotFoundException;
import com.adviceapp.adviceapp.mapper.ContentMapper;
import com.adviceapp.adviceapp.repository.ContentRepository;
import com.adviceapp.adviceapp.service.ContentService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Data
public class ContentServiceImpl implements ContentService {
    private ContentRepository contentRepository;

    @Override
    public ContentDto createContent(ContentDto contentDto) {
        Content content = ContentMapper.mapToContent(contentDto);
        Content savedContent = contentRepository.save(content);
        return ContentMapper.mapToContentDto(savedContent);
    }

    @Override
    public ContentDto getContentById(Long contentID) {
        Content content = contentRepository.findById(contentID).orElseThrow(() ->
                new ResourceNotFoundException("Content is not exist with a given id :" + contentID));
        return ContentMapper.mapToContentDto(content);
    }

    @Override
    public List<ContentDto> gelAllContents() {
        List<Content> contents = contentRepository.findAll();
        return contents.stream().map((content) -> ContentMapper.mapToContentDto(content)).collect(Collectors.toList());
    }

    @Override
    public ContentDto updateContent(Long contentId, ContentDto updatedContent) {
        Content content = contentRepository.findById(contentId).orElseThrow(
                () -> new ResourceNotFoundException("Content is not exists with given id: " + contentId));
        content.setContentName(updatedContent.getContentName());
        content.setContentDuration(updatedContent.getContentDuration());
        content.setContentType(updatedContent.getContentType());

        Content updatedContentObj = contentRepository.save(content);
        return ContentMapper.mapToContentDto(updatedContentObj);
    }

    @Override
    public void deleteContent(Long contentId) {
        Content content = contentRepository.findById(contentId).orElseThrow(
                () -> new ResourceNotFoundException("Content is not exists with given id: " + contentId)
        );
        contentRepository.deleteById(contentId);
    }

}
