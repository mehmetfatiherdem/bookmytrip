package com.virtuous.bookmytripservice.model;

import com.virtuous.bookmytripservice.model.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "passengers")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "passenger_id")
    private UUID id;

    @Column(name = "identification_number", nullable = false)
    private String identificationNumber;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @Column(name = "age")
    private Integer age;

    @OneToOne(mappedBy = "passenger")
    private Ticket ticket;

}
