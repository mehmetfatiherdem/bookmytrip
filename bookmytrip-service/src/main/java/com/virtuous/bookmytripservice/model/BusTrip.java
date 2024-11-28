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
@Table(name = "bus_trips")
public class BusTrip extends Trip {

    @Column(name = "bus_trip_number", nullable = false)
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

}
