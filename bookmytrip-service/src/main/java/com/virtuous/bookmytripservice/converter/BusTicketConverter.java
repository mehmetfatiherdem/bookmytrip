package com.virtuous.bookmytripservice.converter;

import com.virtuous.bookmytripservice.dto.response.BusTicketResponse;
import com.virtuous.bookmytripservice.dto.response.BusTicketSearchResponse;
import com.virtuous.bookmytripservice.model.BusTicket;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class BusTicketConverter {

    public static BusTicketResponse toResponse(BusTicket busTicket) {
        return BusTicketResponse.builder()
                .tripNumber(busTicket.getTripNumber())
                .build();
    }

    public static List<BusTicketResponse> toResponse(List<BusTicket> busTicket) {
        return busTicket
                .stream()
                .map(BusTicketConverter::toResponse)
                .toList();
    }

    public static BusTicketSearchResponse toResponse(Page<BusTicket> blogs) {
        BusTicketSearchResponse response = new BusTicketSearchResponse();

        // set fields

        return response;
    }
}
