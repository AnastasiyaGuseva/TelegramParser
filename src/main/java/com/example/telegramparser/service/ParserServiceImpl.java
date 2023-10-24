package com.example.telegramparser.service;

import com.example.telegramparser.model.Message;
import com.example.telegramparser.repository.MessageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParserServiceImpl implements ParserService {
    private final MessageRepository messageRepository;

    public ParserServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Transactional
    @Override
    public List<Message> dataByDate(Integer date) {
        List<Message> messages = new ArrayList<>();
        messages.add(messageRepository.findMessageByDate(date));
        return messages;
    }

    @Override
    public void saveMessage(Message message) {
        List<Message>messages=new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            messages.add(message);
        }
        messageRepository.save(message);
    }
}
