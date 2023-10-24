package com.example.telegramparser.service;

import com.example.telegramparser.model.Message;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ParserService {
  List<Message> dataByDate(Integer date);
  void saveMessage(Message message);
}
