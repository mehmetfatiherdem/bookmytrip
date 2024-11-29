package com.virtuous.bookmytripservice.model;

import com.virtuous.bookmytripservice.model.enums.TimeZoneEnum;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;

import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "bus_terminals")
@SQLRestriction("deleted_at IS NULL")
public class BusTerminal extends Auditable {

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

    @Enumerated(EnumType.STRING)
    @Column(name = "timezone", nullable = false)
    private TimeZoneEnum timezone;

    @OneToMany(mappedBy = "departureBusTerminal")
    private Set<BusTrip> departureBusTrips;

    @OneToMany(mappedBy = "arrivalBusTerminal")
    private Set<BusTrip> arrivalBusTrips;
}
