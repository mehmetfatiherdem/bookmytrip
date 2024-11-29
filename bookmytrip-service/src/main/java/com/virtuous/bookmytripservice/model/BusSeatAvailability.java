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
@Table(name = "bus_seat_availabilities")
@SQLRestriction("deleted_at IS NULL")
public class BusSeatAvailability extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "bus_seat_availability_id")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bus_trip_id", nullable = false)
    private BusSeat busSeat;

    @Column(name = "is_available", nullable = false)
    private Boolean isAvailable;

}
