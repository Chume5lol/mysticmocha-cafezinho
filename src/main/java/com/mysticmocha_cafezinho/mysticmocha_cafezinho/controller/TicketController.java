package com.mysticmocha_cafezinho.mysticmocha_cafezinho.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysticmocha_cafezinho.mysticmocha_cafezinho.domain.Ticket;
import com.mysticmocha_cafezinho.mysticmocha_cafezinho.dto.TicketDTO;
import com.mysticmocha_cafezinho.mysticmocha_cafezinho.service.TicketService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/ticket")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @PostMapping
    public ResponseEntity<Ticket> ticketCreation(@RequestBody TicketDTO ticket, Authentication authentication) {
        
        Ticket tick = ticketService.createTicket(ticket, authentication);

        return ResponseEntity.ok(tick);
    }
}
