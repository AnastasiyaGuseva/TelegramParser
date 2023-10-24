package com.example.telegramparser.config;

import com.example.telegramparser.utils.ParsingBot;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.LongPollingBot;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Component
public class BotConfigInitializer {
        private final ParsingBot bot;

    public BotConfigInitializer(ParsingBot bot) {
        this.bot = bot;
    }

    @EventListener({ContextRefreshedEvent.class})
        public void init() {
            try {
                TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
                telegramBotsApi.registerBot((LongPollingBot) bot);
            } catch (TelegramApiException e) {
                System.out.println(e.getMessage());
            }
        }

    }
