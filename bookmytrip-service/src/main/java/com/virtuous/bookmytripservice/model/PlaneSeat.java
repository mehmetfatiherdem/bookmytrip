package com.virtuous.bookmytripservice.model;


import com.virtuous.bookmytripservice.model.enums.Letter;
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
@Table(name = "plane_seats")
public class PlaneSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "plane_seat_id")
    private UUID id;

    @Column(name = "plane_seat_number", nullable=false)
    private int number;

    @Enumerated(EnumType.STRING)
    @Column(name = "plane_seat_letter", nullable=false)
    private Letter letter;

    @ManyToMany(mappedBy = "planeSeats")
    private Set<Plane> planes;

    @ManyToMany(mappedBy = "takenPlaneSeats")
    private Set<PlaneTicket> planeTickets;
}
