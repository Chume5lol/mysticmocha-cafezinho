package com.mysticmocha_cafezinho.mysticmocha_cafezinho.domain;

import java.time.LocalDateTime;
import java.util.List;

import com.mysticmocha_cafezinho.mysticmocha_cafezinho.domain.enums.Priority;
import com.mysticmocha_cafezinho.mysticmocha_cafezinho.domain.enums.Status;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
 
@Entity
@Getter
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Priority priority;
    
    @JoinColumn(name = "categority_id")
    @ManyToOne
    private Category categority;

    @Column(nullable = false)
    private LocalDateTime createdAt;
    
    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
    private List<Comment> comments;

    @Column
    private LocalDateTime updateTime;

    @Column
    private LocalDateTime closedAt;

    @JoinColumn(name = "requester_id")
    @ManyToOne
    private Users requester;

    @JoinColumn(name = "agent_id")
    @ManyToOne
    private Users agent;

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setCategority(Category categority) {
        this.categority = categority;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public void setClosedAt(LocalDateTime closedAt) {
        this.closedAt = closedAt;
    }

    public void setRequester(Users requester) {
        this.requester = requester;
    }

    public void setAgent(Users agent) {
        this.agent = agent;
    }

    

    public Ticket() {
    }

    public Ticket(Long id, String title, String description, Status status, Priority priority, Category categority,
            LocalDateTime createdAt, Users requester) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.categority = categority;
        this.createdAt = createdAt;
        this.requester = requester;
    }

    
}
