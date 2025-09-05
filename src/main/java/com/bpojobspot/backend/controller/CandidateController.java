package com.bpojobspot.backend.controller;

import com.bpojobspot.backend.model.Candidate;
import com.bpojobspot.backend.repository.CandidateRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    private final CandidateRepository repository;

    public CandidateController(CandidateRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Candidate addCandidate(@RequestBody Candidate candidate) {
        return repository.save(candidate);
    }

    @GetMapping
    public List<Candidate> getCandidates() {
        return repository.findAll();
    }
}
