package com.virtuous.bookmytripservice.model;

import com.virtuous.bookmytripservice.model.enums.TimeZoneEnum;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;

import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "airports")
@SQLRestriction("deleted_at IS NULL")
public class Airport extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "airport_id")
    private UUID id;

    @Column(name = "airport_code", nullable = false, unique = true, length = 3)
    private String code;

    @Column(name = "airport_name", nullable = false)
    private String name;

    @Column(name = "airport_city", nullable = false)
    private String city;

    @Column(name = "airport_country", nullable = false)
    private String country;

    @Enumerated(EnumType.STRING)
    @Column(name = "timezone", nullable = false)
    private TimeZoneEnum timezone;

    @OneToMany(mappedBy = "departureAirport")
    private Set<Flight> departureFlights;

    @OneToMany(mappedBy = "arrivalAirport")
    private Set<Flight> arrivalFlights;

    public void setCode(String code) {
        this.code = code.toUpperCase();
    }

    public void setName(String name) {
        this.name = name.toUpperCase();
    }

    public void setCity(String city) {
        this.city = city.toUpperCase();
    }

    public void setCountry(String country) {
        this.country = country.toUpperCase();
    }
}
