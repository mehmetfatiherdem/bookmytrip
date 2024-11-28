package com.virtuous.bookmytripservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "airlines")
public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "airline_id")
    private UUID id;

    @Column(name = "airline_code", nullable = false, length = 2, unique = true)
    private String code;

    @Column(name = "airline_name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy="airline")
    private Set<Flight> flights;

    @PrePersist
    @PreUpdate
    public void makeCodeUppercase() {
        this.code = this.code.toUpperCase();
    }
}
