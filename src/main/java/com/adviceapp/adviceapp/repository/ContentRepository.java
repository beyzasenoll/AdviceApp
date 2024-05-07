package com.adviceapp.adviceapp.repository;

import com.adviceapp.adviceapp.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Long> {
}