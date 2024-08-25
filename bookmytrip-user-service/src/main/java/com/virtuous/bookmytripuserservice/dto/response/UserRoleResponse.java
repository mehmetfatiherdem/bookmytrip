package com.virtuous.bookmytripuserservice.dto.response;

import com.virtuous.bookmytripuserservice.model.Role;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRoleResponse {

    private String name;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Set<RoleResponse> roles;

}
