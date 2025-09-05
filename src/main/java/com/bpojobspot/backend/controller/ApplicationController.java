package com.bpojobspot.backend.controller;

import com.bpojobspot.backend.model.Application;
import com.bpojobspot.backend.model.Candidate;
import com.bpojobspot.backend.model.Job;
import com.bpojobspot.backend.repository.ApplicationRepository;
import com.bpojobspot.backend.repository.CandidateRepository;
import com.bpojobspot.backend.repository.JobRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private final ApplicationRepository appRepository;
    private final CandidateRepository candidateRepository;
    private final JobRepository jobRepository;

    public ApplicationController(ApplicationRepository appRepository,
                                 CandidateRepository candidateRepository,
                                 JobRepository jobRepository) {
        this.appRepository = appRepository;
        this.candidateRepository = candidateRepository;
        this.jobRepository = jobRepository;
    }

    @PostMapping
    public Application apply(@RequestParam Long candidateId, @RequestParam Long jobId) {
        Candidate candidate = candidateRepository.findById(candidateId).orElseThrow();
        Job job = jobRepository.findById(jobId).orElseThrow();

        Application application = new Application();
        application.setCandidate(candidate);
        application.setJob(job);

        return appRepository.save(application);
    }

    @GetMapping
    public List<Application> getApplications() {
        return appRepository.findAll();
    }
}
