package com.adviceapp.adviceapp.controller;

import com.adviceapp.adviceapp.dto.ContentDto;
import com.adviceapp.adviceapp.dto.UserDto;
import com.adviceapp.adviceapp.service.ContentService;
import com.adviceapp.adviceapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/content")
public class ContentController {
    private static final Logger logger = LoggerFactory.getLogger(ContentController.class);
    private ContentService contentService;

    @PostMapping
    public ResponseEntity<ContentDto> createContent(@RequestBody ContentDto contentDto) {
        logger.info("Creating content: {}", contentDto);
        ContentDto savedContent = contentService.createContent(contentDto);
        logger.info("Content created: {}", savedContent);
        return new ResponseEntity<>(savedContent, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ContentDto> getContentById(@PathVariable("id") Long contentId) {
        logger.info("Getting content by id: {}", contentId);
        ContentDto contentDto = contentService.getContentById(contentId);
        logger.info("Retrieved content: {}", contentDto);
        return ResponseEntity.ok(contentDto);
    }

    @GetMapping
    public ResponseEntity<List<ContentDto>> getAllContents() {
        logger.info("Getting all contents");
        List<ContentDto> contents = contentService.gelAllContents();
        logger.info("Retrieved {} contents", contents.size());
        return ResponseEntity.ok(contents);
    }

    @PutMapping("{id}")
    public ResponseEntity<ContentDto> updateContent(@PathVariable("id") Long contentId,
                                                    @RequestBody ContentDto updatedContent) {
        logger.info("Updating content with id {}: {}", contentId, updatedContent);
        ContentDto contentDto = contentService.updateContent(contentId, updatedContent);
        logger.info("Updated content: {}", contentDto);
        return ResponseEntity.ok(contentDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteContent(@PathVariable("id") Long contentId) {
        logger.info("Deleting content with id: {}", contentId);
        contentService.deleteContent(contentId);
        logger.info("Content deleted successfully!");
        return ResponseEntity.ok("Content deleted successfully!");
    }

}
