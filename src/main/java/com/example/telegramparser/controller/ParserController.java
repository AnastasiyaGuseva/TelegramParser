package com.example.telegramparser.controller;

import com.example.telegramparser.dto.DtoMessage;
import com.example.telegramparser.service.ParserService;
import com.example.telegramparser.utils.MessageMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class ParserController {

    private final ParserService parserService;
    private final MessageMapper messageMapper;

    public ParserController(ParserService parserService, MessageMapper messageMapper) {
        this.parserService = parserService;
        this.messageMapper = messageMapper;
    }

    @GetMapping("/date")
    public List<DtoMessage> getDataByDate(@RequestParam Integer date) {
        return messageMapper.toDto(parserService.dataByDate(date));
    }
}
