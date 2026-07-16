package com.mysticmocha_cafezinho.mysticmocha_cafezinho.dto;

import java.time.LocalDateTime;

public record CommentDTO(
    Long id,
    String message,
    LocalDateTime sendDate,
    String authorName,
    Long ticketId
){}
