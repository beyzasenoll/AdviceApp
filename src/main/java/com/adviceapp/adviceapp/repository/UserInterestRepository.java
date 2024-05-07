package com.adviceapp.adviceapp.repository;

import com.adviceapp.adviceapp.entity.UserInterests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInterestRepository extends JpaRepository<UserInterests, Long> {
}
