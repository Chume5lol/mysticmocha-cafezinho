package com.mysticmocha_cafezinho.mysticmocha_cafezinho.dto;

import com.mysticmocha_cafezinho.mysticmocha_cafezinho.domain.enums.Priority;

public record TicketDTO(
        String title,
        String description,
        Priority priority,
        Long categorityId) {
}
