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
@Table(name = "airport")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", nullable = false, unique = true, length = 3)
    private String code;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "country", nullable = false)
    private String country;

    @OneToMany(mappedBy = "departureAirport")
    private Set<PlaneTicket> departurePlaneTickets;

    @OneToMany(mappedBy = "arrivalAirport")
    private Set<PlaneTicket> arrivalPlaneTickets;

    @PrePersist
    @PreUpdate
    public void makeCodeUppercase() {
        this.code = this.code.toUpperCase();
    }
}
