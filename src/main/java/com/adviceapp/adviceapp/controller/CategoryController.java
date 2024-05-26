package com.adviceapp.adviceapp.controller;

import com.adviceapp.adviceapp.dto.CategoryDto;
import com.adviceapp.adviceapp.dto.ContentDto;
import com.adviceapp.adviceapp.service.ContentService;
import com.adviceapp.adviceapp.service.impl.CategoryServiceImpl;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
    private CategoryServiceImpl categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getCategories() {
        logger.info("Getting all categories");
        List<CategoryDto> categories = categoryService.getCategories();
        logger.info("Retrieved {} categories", categories.size());
        return ResponseEntity.ok(categories);
    }


}
