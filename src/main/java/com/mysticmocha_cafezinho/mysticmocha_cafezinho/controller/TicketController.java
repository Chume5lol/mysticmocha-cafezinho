package com.mysticmocha_cafezinho.mysticmocha_cafezinho.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysticmocha_cafezinho.mysticmocha_cafezinho.domain.Ticket;
import com.mysticmocha_cafezinho.mysticmocha_cafezinho.dto.TicketDTO;
import com.mysticmocha_cafezinho.mysticmocha_cafezinho.dto.TicketResponse;
import com.mysticmocha_cafezinho.mysticmocha_cafezinho.service.TicketService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/ticket")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;


    // Users, Agents e Administrators 
    @PostMapping
    public ResponseEntity<Ticket> ticketCreation(@RequestBody TicketDTO ticket, Authentication authentication) {
        
        Ticket tick = ticketService.createTicket(ticket, authentication);

        return ResponseEntity.ok(tick);
    }

    // Users
    @GetMapping("/view")
    public List<TicketResponse> ticketsView(Authentication authentication) {

        return ticketService.findAllByuserNickname(authentication.getName());
    }

    @GetMapping("/view/{id}")
    public List<TicketResponse> uniqueTicketView(@PathVariable Long id, Authentication authentication) {
        return ticketService.findByIdAndUser(authentication, id);
    }


    // Agents


    // Administrators



}
