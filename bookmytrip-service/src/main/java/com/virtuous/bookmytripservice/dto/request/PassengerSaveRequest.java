package com.virtuous.bookmytripservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PassengerSaveRequest {
    private String identificationNumber;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String gender;
    private Integer age;
}
