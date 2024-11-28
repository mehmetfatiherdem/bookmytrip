package com.virtuous.bookmytripservice.model;

import com.virtuous.bookmytripservice.model.enums.TicketStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="tickets")
@Inheritance(strategy = InheritanceType.JOINED)
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ticket_id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;

    @Enumerated(EnumType.STRING)
    @Column(name = "ticket_status", nullable = false)
    private TicketStatus status;

    @Column(name = "trip_price", nullable = false)
    private BigDecimal price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passenger_id", referencedColumnName = "passenger_id")
    private Passenger passenger;

    @Column (name = "userId", nullable = false)
    private UUID userId;


    @PrePersist
    @PreUpdate
    public void pricePrecisionConvertion() {
        // convert your bigdecimal scale to 2 here
        this.price.setScale(2, RoundingMode.HALF_UP);
    }

}
