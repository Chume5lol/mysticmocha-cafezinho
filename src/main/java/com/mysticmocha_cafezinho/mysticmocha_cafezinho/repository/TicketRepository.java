package com.mysticmocha_cafezinho.mysticmocha_cafezinho.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mysticmocha_cafezinho.mysticmocha_cafezinho.domain.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query("""
            SELECT t
            FROM Ticket t
            WHERE t.requester.id = :id
            """)
    List<Ticket> findByRequester(@Param("id") Long id);

}
