package com.bpojobspot.backend.controller;

import com.bpojobspot.backend.model.Job;
import com.bpojobspot.backend.repository.JobRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private final JobRepository repository;

    public JobController(JobRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Job addJob(@RequestBody Job job) {
        return repository.save(job);
    }

    @GetMapping
    public List<Job> getJobs() {
        return repository.findAll();
    }
}
