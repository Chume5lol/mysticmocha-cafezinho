package com.mysticmocha_cafezinho.mysticmocha_cafezinho.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.mysticmocha_cafezinho.mysticmocha_cafezinho.domain.Ticket;
import com.mysticmocha_cafezinho.mysticmocha_cafezinho.domain.Users;
import com.mysticmocha_cafezinho.mysticmocha_cafezinho.domain.enums.Status;
import com.mysticmocha_cafezinho.mysticmocha_cafezinho.dto.TicketDTO;
import com.mysticmocha_cafezinho.mysticmocha_cafezinho.dto.TicketResponse;
import com.mysticmocha_cafezinho.mysticmocha_cafezinho.repository.CategoryRepository;
import com.mysticmocha_cafezinho.mysticmocha_cafezinho.repository.TicketRepository;
import com.mysticmocha_cafezinho.mysticmocha_cafezinho.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public Ticket createTicket(TicketDTO ticketDTO, Authentication authentication) {

        try {
            Ticket ticket = new Ticket();
            ticket.setTitle(ticketDTO.title());
            ticket.setDescription(ticketDTO.title());
            ticket.setCategority(categoryRepository.findById(ticketDTO.categorityId()).orElseThrow());
            ticket.setPriority(ticketDTO.priority());
            ticket.setStatus(Status.AWAITING_SERVICE);
            ticket.setCreatedAt(LocalDateTime.now());
            ticket.setRequester(userRepository.findByNickname(authentication.getName()).orElseThrow());

            return ticketRepository.save(ticket);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    public List<TicketResponse> findAllByuserNickname(String name) {
        try {
            Users user = userRepository.findByNickname(name).orElseThrow();
            System.out.println("Usuário: " + user.getId());
            return ticketRepository.findByRequester(user.getId())
                    .stream()
                    .map(ticket -> new TicketResponse(
                            ticket.getId(),
                            ticket.getTitle(),
                            ticket.getDescription(),
                            ticket.getStatus(),
                            ticket.getPriority(),
                            ticket.getRequester().getNickname(),
                            ticket.getAgent() != null ? ticket.getAgent().getNickname() : null,
                            ticket.getCategority() != null ? ticket.getCategority().getName() : null,
                            ticket.getCreatedAt()))
                    .toList();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
