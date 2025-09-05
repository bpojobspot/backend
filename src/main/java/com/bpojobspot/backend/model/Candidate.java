package com.bpojobspot.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;
    private String skills;
    private String shiftPreference;
}
