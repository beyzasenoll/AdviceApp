package com.adviceapp.adviceapp.controller;

import com.adviceapp.adviceapp.dto.ContentDto;
import com.adviceapp.adviceapp.dto.UserDto;
import com.adviceapp.adviceapp.service.ContentService;
import com.adviceapp.adviceapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/content")
public class ContentController {
        private ContentService contentService;

        @PostMapping
        public ResponseEntity<ContentDto> createContent(@RequestBody ContentDto contentDto) {
            ContentDto savedContent = contentService.createContent(contentDto);
            return new ResponseEntity<>(savedContent, HttpStatus.CREATED);
        }

        @GetMapping("{id}")
        public ResponseEntity<ContentDto> getContentbyId(@PathVariable("id") Long contentId) {
            ContentDto contentDto = contentService.getContentById(contentId);
            return ResponseEntity.ok(contentDto);
        }

        @GetMapping
        public ResponseEntity<List<ContentDto>> getALlContents() {
            List<ContentDto> contents = contentService.gelAllContents();
            return ResponseEntity.ok(contents);
        }

        @PutMapping("{id}")
        public ResponseEntity<ContentDto> updateContent(@PathVariable("id") Long contentId,
                                                      @RequestBody ContentDto updatedContent) {
            ContentDto contentDto = contentService.updateContent(contentId, updatedContent);
            return ResponseEntity.ok(contentDto);
        }

        @DeleteMapping("{id}")
        public ResponseEntity<String> deleteContent(@PathVariable("id") Long contentId) {
            contentService.deleteContent(contentId);
            return ResponseEntity.ok("Content deleted succesfully!");
        }
}
