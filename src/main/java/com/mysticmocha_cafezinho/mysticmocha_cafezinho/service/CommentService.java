package com.mysticmocha_cafezinho.mysticmocha_cafezinho.service;

import java.time.LocalDateTime;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.mysticmocha_cafezinho.mysticmocha_cafezinho.domain.Comment;
import com.mysticmocha_cafezinho.mysticmocha_cafezinho.dto.CommentDTO;
import com.mysticmocha_cafezinho.mysticmocha_cafezinho.repository.CommentRepository;
import com.mysticmocha_cafezinho.mysticmocha_cafezinho.repository.TicketRepository;
import com.mysticmocha_cafezinho.mysticmocha_cafezinho.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final TicketRepository ticketRepository;

    public CommentDTO createComment(Long ticketId, Authentication authentication, String message) {

        try {
            Comment comment = new Comment();
            comment.setMessage(message);
            comment.setAuthor(userRepository.findByNickname(authentication.getName()).orElseThrow());
            comment.setCreatedAt(LocalDateTime.now());
            comment.setTicket(ticketRepository.findById(ticketId).orElseThrow());
            Comment savedComment = commentRepository.save(comment);

            CommentDTO commentDTO = new CommentDTO(
                savedComment.getId(),
                savedComment.getMessage(),
                savedComment.getCreatedAt(),
                savedComment.getAuthor().getNickname(),
                savedComment.getTicket().getId()
            );
            

            return commentDTO;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
