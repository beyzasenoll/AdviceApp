package com.adviceapp.adviceapp.repository;

import com.adviceapp.adviceapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}