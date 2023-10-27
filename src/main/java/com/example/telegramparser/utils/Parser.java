package com.example.telegramparser.utils;

import com.example.telegramparser.model.Message;
import com.example.telegramparser.service.ParserService;
import it.tdlight.jni.TdApi;
import org.springframework.stereotype.Component;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

@Component
public class Parser {

    private final Deque<TdApi.Message> messages = new ConcurrentLinkedDeque<>();

    private final ParserService parserService;

    public Parser(ParserService parserService) {
        this.parserService = parserService;
    }


    public void putMessage(TdApi.Message message) {
        messages.addLast(message);
    }

    public void message(Message message) {
        for (int i = 0; i < 100; i++) {
            TdApi.Message msg = messages.pollFirst();
            if (message == null) {
                break;
            }
            Message saveMessage = new Message();
            assert msg != null;
            saveMessage.setId(msg.id);
            saveMessage.setDate(msg.date);
            saveMessage.setEdited(msg.editDate);
            saveMessage.setFromId(msg.chatId);
            saveMessage.setText(msg.content.toString());
        }
        parserService.saveMessage(message);

    }

}
