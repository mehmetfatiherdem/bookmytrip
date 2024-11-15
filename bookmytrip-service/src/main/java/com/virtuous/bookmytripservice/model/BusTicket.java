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
@Table(name = "bus_tickets")
public class BusTicket extends Ticket{

    @Column(name = "bus_ticket_trip_number", nullable = false)
    private String tripNumber;

    @ManyToOne
    @JoinColumn(name = "departure_bus_terminal_id", nullable = false)
    private BusTerminal departureBusTerminal;

    @ManyToOne
    @JoinColumn(name = "arrival_bus_terminal_id", nullable = false)
    private BusTerminal arrivalBusTerminal;

    @ManyToOne
    @JoinColumn(name = "bus_operator_id", nullable = false)
    private BusOperator busOperator;

    @ManyToOne
    @JoinColumn(name="bus_id", nullable=false)
    private Bus bus;

    @ManyToMany
    @JoinTable(
            name = "taken_bus_seats",
            joinColumns = @JoinColumn(name = "bus_ticket_id"),
            inverseJoinColumns = @JoinColumn(name = "bus_seat_id"))
    private Set<BusSeat> takenBusSeats;
}
