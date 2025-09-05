package com.bpojobspot.backend.repository;

import com.bpojobspot.backend.model.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employer, Long> {
}
