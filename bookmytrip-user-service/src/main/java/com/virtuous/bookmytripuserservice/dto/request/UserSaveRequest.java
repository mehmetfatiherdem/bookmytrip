package com.virtuous.bookmytripuserservice.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserSaveRequest {

    private String name;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;

}