package com.mysticmocha_cafezinho.mysticmocha_cafezinho.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mysticmocha_cafezinho.mysticmocha_cafezinho.domain.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{


    List<Comment> findByTicketId(Long id);
}
