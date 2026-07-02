package com.mysticmocha_cafezinho.mysticmocha_cafezinho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mysticmocha_cafezinho.mysticmocha_cafezinho.domain.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long>{

}
