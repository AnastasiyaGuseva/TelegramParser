package com.example.telegramparser.repository;

import com.example.telegramparser.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    Message findMessageByDate(Integer date);
}
