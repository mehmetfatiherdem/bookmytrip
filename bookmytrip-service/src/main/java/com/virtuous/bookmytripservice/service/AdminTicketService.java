package com.virtuous.bookmytripservice.service;

import com.virtuous.bookmytripservice.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminTicketService {

    private final TicketRepository ticketRepository;


}
