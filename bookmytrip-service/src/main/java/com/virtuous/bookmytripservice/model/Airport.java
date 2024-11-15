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
@Table(name = "airports")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "airport_id")
    private UUID id;

    @Column(name = "airport_code", nullable = false, unique = true, length = 3)
    private String code;

    @Column(name = "airport_name", nullable = false)
    private String name;

    @Column(name = "airport_city", nullable = false)
    private String city;

    @Column(name = "airport_country", nullable = false)
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
