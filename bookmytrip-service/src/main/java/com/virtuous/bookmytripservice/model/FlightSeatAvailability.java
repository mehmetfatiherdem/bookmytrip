package com.virtuous.bookmytripservice.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "flight_seat_availabilities")
@SQLRestriction("deleted_at IS NULL")
public class FlightSeatAvailability extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "flight_seat_availability_id")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plane_seat_id", nullable = false)
    private PlaneSeat planeSeat;

    @Column(name = "is_available", nullable = false)
    private Boolean isAvailable;
}
