package com.example.telegramparser.service;

import com.example.telegramparser.model.Message;

import java.util.List;

public interface ParserService {
    List<Message> dataByDate(Integer date);

    void saveMessage(Message message);

}
