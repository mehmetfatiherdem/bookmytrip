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
@Table(name = "bus_seats")
public class BusSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "bus_seat_id")
    private UUID id;

    @Column(name = "bus_seat_number", nullable=false)
    private int number;

    @ManyToMany(mappedBy = "existingBusSeats")
    private Set<Bus> buses;

    @OneToMany(mappedBy = "busSeat")
    private Set<BusTicket> busTickets;

    @OneToMany(mappedBy = "busSeat")
    private Set<BusSeatAvailability> busSeatAvailabilities;
}
