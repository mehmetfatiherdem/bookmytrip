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
@Table(name = "flights")
public class Flight extends Trip {

    @Column(name = "flight_number", nullable = false)
    private String flightNumber;

    @ManyToOne
    @JoinColumn(name = "departure_airport_id", nullable = false)
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(name = "arrival_airport_id", nullable = false)
    private Airport arrivalAirport;

    @ManyToOne
    @JoinColumn(name="airline_id", nullable=false)
    private Airline airline;

    @ManyToOne
    @JoinColumn(name="plane_id", nullable=false)
    private Plane plane;

    @OneToMany(mappedBy = "flight")
    private Set<FlightSeatAvailability> flightSeatAvailabilities;

}
