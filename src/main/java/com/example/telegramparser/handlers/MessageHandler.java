package com.example.telegramparser.handlers;


import com.example.telegramparser.utils.Parser;
import it.tdlight.jni.TdApi;
import org.springframework.stereotype.Component;

@Component

public class MessageHandler implements UpdateNotificationListener<TdApi.UpdateNewMessage> {

    private final Parser parser;

    public MessageHandler(Parser parser) {
        this.parser = parser;

    }

    @Override
    public void handleNotification(TdApi.UpdateNewMessage notification) {
        parser.putMessage(notification.message);
    }

    @Override
    public Class<TdApi.UpdateNewMessage> notificationType() {
        return TdApi.UpdateNewMessage.class;
    }

}