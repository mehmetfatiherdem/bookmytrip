package com.virtuous.bookmytripservice.dto.response;

import com.virtuous.bookmytripservice.model.enums.Gender;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PassengerResponse {
    private String identificationNumber;
    private String name;
    private String lastName;
    private String phoneNumber;
    private Gender gender;
    private Integer age;
}
