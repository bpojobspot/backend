package com.bpojobspot.backend.repository;

import com.bpojobspot.backend.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
