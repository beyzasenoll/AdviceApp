package com.adviceapp.adviceapp.repository;

import com.adviceapp.adviceapp.entity.Content;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface ContentRepository extends JpaRepository<Content, Long> {
    List<Content> findByCategoryId(Long categoryId);


}