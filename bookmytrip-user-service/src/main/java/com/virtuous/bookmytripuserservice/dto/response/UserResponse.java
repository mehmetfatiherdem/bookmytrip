package com.virtuous.bookmytripuserservice.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    private String name;
    private String lastName;
    private String email;
    private String bio;
    private String phoneNumber;
}
