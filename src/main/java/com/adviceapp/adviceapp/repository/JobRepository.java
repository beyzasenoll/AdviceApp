package com.adviceapp.adviceapp.repository;

import com.adviceapp.adviceapp.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
}

