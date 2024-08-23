package com.virtuous.bookmytripservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "airline")
public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", nullable = false, length = 2, unique = true)
    private String code;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy="airline")
    private Set<PlaneTicket> planeTickets;

    @PrePersist
    @PreUpdate
    public void makeCodeUppercase() {
        this.code = this.code.toUpperCase();
    }
}
