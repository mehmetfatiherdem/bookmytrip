package com.virtuous.bookmytripservice.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "bus_tickets")
public class BusTicket extends Ticket{

    @ManyToOne
    @JoinColumn(name = "bus_ticket_seat")
    private BusSeat busSeat;

    @Column(name = "platform")
    private String platform;
}
