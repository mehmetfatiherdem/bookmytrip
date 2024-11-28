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
@Table(name = "bus_operators")
public class BusOperator {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "bus_operator_id")
    private UUID id;

    @Column(name = "bus_operator_name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "busOperator")
    private Set<BusTrip> busTrips;
}
