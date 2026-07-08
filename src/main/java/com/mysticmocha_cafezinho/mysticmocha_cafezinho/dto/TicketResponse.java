package com.mysticmocha_cafezinho.mysticmocha_cafezinho.dto;

import java.time.LocalDateTime;

import com.mysticmocha_cafezinho.mysticmocha_cafezinho.domain.enums.Priority;
import com.mysticmocha_cafezinho.mysticmocha_cafezinho.domain.enums.Status;

public record TicketResponse(
    Long id,
    String title,
    String description,
    Status status,
    Priority priority,
    String requester,
    String agent,
    String categority,
    LocalDateTime createdAt
) {}

