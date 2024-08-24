package com.virtuous.bookmytripservice.dto.response;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BusOperatorResponse implements Serializable {
    private String name;

}
