package com.virtuous.bookmytripgw.exception;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionMessages {

    public static final String BUS_TERMINAL_NOT_FOUND = "Bus terminal not found";
    public static final String BUS_OPERATOR_NOT_FOUND = "Bus operator not found";
    public static final String BUS_NOT_FOUND = "Bus not found";
    public static final String AIRPORT_NOT_FOUND = "Airport not found";
    public static final String AIRLINE_NOT_FOUND = "Airline not found";
    public static final String PLANE_NOT_FOUND = "Plane not found";

}
