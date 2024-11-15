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
@Table(name = "bus_terminals")
public class BusTerminal {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "bus_terminal_id")
    private UUID id;

    @Column(name = "bus_terminal_name", nullable = false)
    private String name;

    @Column(name = "bus_terminal_city", nullable = false)
    private String city;

    @Column(name = "bus_terminal_country", nullable = false)
    private String country;

    @OneToMany(mappedBy = "departureBusTerminal")
    private Set<BusTicket> departureBusTickets;

    @OneToMany(mappedBy = "arrivalBusTerminal")
    private Set<BusTicket> arrivalBusTickets;
}
