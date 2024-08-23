package com.virtuous.bookmytripservice.model;


import com.virtuous.bookmytripservice.model.enums.Letter;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "plane_seat")
public class PlaneSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number", nullable=false)
    private int number;

    @Enumerated(EnumType.STRING)
    private Letter letter;

    @ManyToMany
    private Set<Plane> planes;

    @ManyToMany
    private Set<PlaneTicket> planeTickets;
}
