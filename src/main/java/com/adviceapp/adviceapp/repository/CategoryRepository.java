package com.adviceapp.adviceapp.repository;

import com.adviceapp.adviceapp.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
