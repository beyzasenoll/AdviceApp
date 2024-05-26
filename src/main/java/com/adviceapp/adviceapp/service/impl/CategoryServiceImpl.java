package com.adviceapp.adviceapp.service.impl;

import com.adviceapp.adviceapp.dto.CategoryDto;
import com.adviceapp.adviceapp.entity.Category;
import com.adviceapp.adviceapp.mapper.ContentMapper;
import com.adviceapp.adviceapp.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;


@Service
@AllArgsConstructor
@Data
public class CategoryServiceImpl {
    private CategoryRepository categoryRepository;

    public List<CategoryDto> getCategories() {

        List<Category> categories = categoryRepository.findAll();

        List<CategoryDto> categoriesDto = categories.stream().map(x ->
                new CategoryDto(
                        x.getId(), x.getCategory_name(), x.getIcon()
                )
        ).toList();

        return categoriesDto;
    }
}