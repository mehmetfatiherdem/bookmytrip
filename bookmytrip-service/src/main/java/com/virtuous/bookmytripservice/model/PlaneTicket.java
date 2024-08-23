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
public class PlaneTicket extends Ticket{

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

    @ManyToMany
    @JoinTable(
            name = "taken_plane_seat",
            joinColumns = @JoinColumn(name = "plane_ticket_id"),
            inverseJoinColumns = @JoinColumn(name = "plane_seat_id"))
    private Set<PlaneSeat> takenPlaneSeats;
}
