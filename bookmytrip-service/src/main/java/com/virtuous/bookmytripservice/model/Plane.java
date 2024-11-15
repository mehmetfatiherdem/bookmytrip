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
@Table(name = "planes")
public class Plane {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "plane_id")
    private UUID id;

    @Column(name = "plane_brand", nullable = false)
    private String brand;

    @Column(name = "plane_model", nullable = false)
    private String model;

    @OneToMany(mappedBy="plane")
    private Set<PlaneTicket> planeTickets;

    @ManyToMany
    @JoinTable(
            name = "existing_plane_seats",
            joinColumns = @JoinColumn(name = "plane_id"),
            inverseJoinColumns = @JoinColumn(name = "plane_seat_id"))
    private Set<PlaneSeat> planeSeats;
}
