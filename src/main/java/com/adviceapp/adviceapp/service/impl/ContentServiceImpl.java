package com.adviceapp.adviceapp.service.impl;

import com.adviceapp.adviceapp.dto.ContentDto;
import com.adviceapp.adviceapp.entity.Category;
import com.adviceapp.adviceapp.entity.Content;
import com.adviceapp.adviceapp.entity.Platform;
import com.adviceapp.adviceapp.exception.ResourceNotFoundException;
import com.adviceapp.adviceapp.mapper.ContentMapper;
import com.adviceapp.adviceapp.repository.CategoryRepository;
import com.adviceapp.adviceapp.repository.ContentRepository;
import com.adviceapp.adviceapp.repository.PlatformRepository;
import com.adviceapp.adviceapp.service.ContentService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
@Data
public class ContentServiceImpl implements ContentService {
    private ContentRepository contentRepository;
    private PlatformRepository platformRepository;
    private CategoryRepository categoryRepository;

    @Override
    public ContentDto createContent(ContentDto contentDto) {
        Content content = ContentMapper.mapToContent(contentDto);

        // Ensure the Platform entity is managed
        Platform platform = content.getPlatform();
        if (platform != null && platform.getPlatform_id() == null) {
            platform = platformRepository.save(platform);
            content.setPlatform(platform);
        }

        // Ensure the Category entity is managed
        Category category = categoryRepository.findById(content.getCategory().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + content.getCategory().getId()));
        content.setCategory(category);

        Content savedContent = contentRepository.save(content);
        return ContentMapper.mapToContentDto(savedContent);
    }

    @Override
    public ContentDto getContentById(Long contentID) {
        Content content = contentRepository.findById(contentID).orElseThrow(() ->
                new ResourceNotFoundException("Content does not exist with the given id: " + contentID));
        return ContentMapper.mapToContentDto(content);
    }

    @Override
    public List<ContentDto> gelAllContents() {
        List<Content> contents = contentRepository.findAll();
        return contents.stream().map(ContentMapper::mapToContentDto).collect(Collectors.toList());
    }

    @Override
    public ContentDto updateContent(Long contentId, ContentDto updatedContent) {
        Content content = contentRepository.findById(contentId).orElseThrow(
                () -> new ResourceNotFoundException("Content does not exist with the given id: " + contentId));
        content.setTitle(updatedContent.getTitle());
        content.setDuration(updatedContent.getDuration());
        content.setType(updatedContent.getType());

        Content updatedContentObj = contentRepository.save(content);
        return ContentMapper.mapToContentDto(updatedContentObj);
    }

    @Override
    public void deleteContent(Long contentId) {
        Content content = contentRepository.findById(contentId).orElseThrow(
                () -> new ResourceNotFoundException("Content does not exist with the given id: " + contentId)
        );
        contentRepository.deleteById(contentId);
    }
}