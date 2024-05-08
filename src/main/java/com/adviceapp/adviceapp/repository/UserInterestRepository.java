package com.adviceapp.adviceapp.repository;

import com.adviceapp.adviceapp.entity.UserInterest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInterestRepository extends JpaRepository<UserInterest, Long> {
}
