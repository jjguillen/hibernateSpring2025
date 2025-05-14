package com.jaroso.hibernate.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "companies")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String address;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "company")
    private Set<Employee> employees = new HashSet<>();

}
