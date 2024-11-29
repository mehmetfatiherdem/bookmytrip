package com.virtuous.bookmytripservice.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "bus_tickets")
@SQLRestriction("deleted_at IS NULL")
public class BusTicket extends Ticket{

    @ManyToOne
    @JoinColumn(name = "bus_ticket_seat")
    private BusSeat busSeat;

    @Column(name = "platform")
    private String platform;
}
