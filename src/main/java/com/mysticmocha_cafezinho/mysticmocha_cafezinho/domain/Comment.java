package com.mysticmocha_cafezinho.mysticmocha_cafezinho.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Entity
@Getter
public class Comment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User author;

    @JoinColumn(name = "ticket_id")
    @ManyToOne
    private Ticket ticket;

    public void setId(Long id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Comment(Long id, String message, LocalDateTime createdAt, User author, Ticket ticket) {
        this.id = id;
        this.message = message;
        this.createdAt = createdAt;
        this.author = author;
        this.ticket = ticket;
    }

    
}
