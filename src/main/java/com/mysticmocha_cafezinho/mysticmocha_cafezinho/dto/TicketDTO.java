package com.mysticmocha_cafezinho.mysticmocha_cafezinho.dto;


import com.mysticmocha_cafezinho.mysticmocha_cafezinho.domain.enums.Priority;
import com.mysticmocha_cafezinho.mysticmocha_cafezinho.domain.enums.Status;

public record TicketDTO(
    String title,
    String description,
    Status status,
    Priority priority,
    Long categorityId,
    Long requesterId
) {}
