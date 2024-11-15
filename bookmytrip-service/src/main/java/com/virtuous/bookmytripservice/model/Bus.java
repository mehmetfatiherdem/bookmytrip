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
@Table(name = "buses")
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "bus_id")
    private UUID id;

    @Column(name = "bus_brand", nullable = false)
    private String brand;

    @Column(name = "bus_model", nullable = false)
    private String model;

    @OneToMany(mappedBy="bus")
    private Set<BusTicket> busTickets;

    @ManyToMany
    @JoinTable(
            name = "existing_bus_seats",
            joinColumns = @JoinColumn(name = "bus_id"),
            inverseJoinColumns = @JoinColumn(name = "bus_seat_id"))
    private Set<BusSeat> existingBusSeats;

}
