package com.virtuous.bookmytripuserservice.exception;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionMessages {

    public static final String USER_NOT_FOUND = "User not found.";
    public static final String USER_ALREADY_DEFINED = "A user with this email already exists.";
    public static final String ROLE_NOT_FOUND = "Role not found.";
    public static final String USER_NOT_FOUND_OR_PASSWORD_IS_WRONG = "User not found or password is wrong.";

}
