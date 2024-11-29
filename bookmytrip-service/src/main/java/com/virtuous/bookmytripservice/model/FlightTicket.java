package com.virtuous.bookmytripservice.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "flight_tickets")
public class FlightTicket extends Ticket {

    @ManyToOne
    @JoinColumn(name = "flight_ticket_seat")
    private PlaneSeat planeSeat;

    @Column(name = "boarding_gate")
    private String boardingGate;

}
