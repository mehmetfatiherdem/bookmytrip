package com.virtuous.bookmytripservice.model;

import com.virtuous.bookmytripservice.model.enums.TripStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;

import java.time.ZonedDateTime;
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
@SQLRestriction("deleted_at IS NULL")
public class Trip extends Auditable {

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

    @Column(name = "departure_time", nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private ZonedDateTime departureTime;

    @Column(name = "arrival_time", nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private ZonedDateTime arrivalTime;

    @OneToMany(mappedBy = "trip")
    private Set<Ticket> tickets;

}
