package com.virtuous.bookmytripservice.model;


import com.virtuous.bookmytripservice.model.enums.Letter;
import com.virtuous.bookmytripservice.model.enums.PlaneSeatClass;
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

    @Enumerated(EnumType.STRING)
    @Column(name = "plane_seat_class", nullable = false)
    private PlaneSeatClass planeSeatClass;

    @ManyToMany(mappedBy = "planeSeats")
    private Set<Plane> planes;

    @OneToMany(mappedBy = "planeSeat")
    private Set<FlightSeatAvailability> flightSeatAvailabilities;

    @OneToMany(mappedBy = "planeSeat")
    private Set<FlightTicket> flightTickets;

}
