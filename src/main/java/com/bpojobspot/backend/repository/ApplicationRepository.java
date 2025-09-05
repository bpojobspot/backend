package com.bpojobspot.backend.repository;

import com.bpojobspot.backend.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
