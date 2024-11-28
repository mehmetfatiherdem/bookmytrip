package com.virtuous.bookmytripservice.model;

import com.virtuous.bookmytripservice.model.enums.TripStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="trips")
@Inheritance(strategy = InheritanceType.JOINED)
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "trip_id")
    private UUID id;

    @Column(name = "departure", nullable = false)
    private String departure;

    @Column(name = "arrival", nullable = false)
    private String arrival;

    @Enumerated(EnumType.STRING)
    @Column(name = "trip_status", nullable = false)
    private TripStatus status;

    @Column(name = "departure_time", nullable = false)
    private LocalDateTime departureTime;

    @Column(name = "arrival_time", nullable = false)
    private LocalDateTime arrivalTime;

    @OneToMany(mappedBy = "trip")
    private Set<Ticket> tickets;

}
