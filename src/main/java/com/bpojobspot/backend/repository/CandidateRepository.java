package com.bpojobspot.backend.repository;


import com.bpojobspot.backend.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
