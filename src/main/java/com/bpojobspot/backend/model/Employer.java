package com.bpojobspot.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private String hrName;
    private String email;
    private String phone;
}
