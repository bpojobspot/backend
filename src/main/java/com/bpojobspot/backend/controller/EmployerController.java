package com.bpojobspot.backend.controller;

import com.bpojobspot.backend.model.Employer;
import com.bpojobspot.backend.repository.EmployerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
public class EmployerController {

    private final EmployerRepository repository;

    public EmployerController(EmployerRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Employer addEmployer(@RequestBody Employer employer) {
        return repository.save(employer);
    }

    @GetMapping
    public List<Employer> getEmployers() {
        return repository.findAll();
    }
}
