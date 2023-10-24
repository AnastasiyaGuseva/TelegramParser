package com.example.telegramparser.utils;

import com.example.telegramparser.config.BotConfig;
import com.example.telegramparser.model.Message;
import com.example.telegramparser.service.ParserService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;


@Component
public class ParsingBot extends TelegramLongPollingBot {
    private final BotConfig botConfig;
    private final ParserService parserService;

    public ParsingBot(BotConfig botConfig, ParserService parserService) {
        this.botConfig = botConfig;
        this.parserService = parserService;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            Message message = new Message();
            message.setId(update.getMessage().getMessageId());
            message.setDate(update.getMessage().getDate());
            message.setEdited(update.getMessage().getEditDate());
            message.setFrom(update.getMessage().getForwardSenderName());
            message.setFromId(update.getMessage().getMigrateFromChatId());
            message.setText(update.getMessage().getText());


            parserService.saveMessage(message);
        }
    }


    @Override
    public String getBotUsername() {
        return botConfig.getBotName();
    }
}
