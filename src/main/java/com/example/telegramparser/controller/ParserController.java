package com.example.telegramparser.controller;

import com.example.telegramparser.dto.DtoMessage;
import com.example.telegramparser.service.ParserService;
import com.example.telegramparser.utils.MessageMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequestMapping("/message")
@RestController
public class ParserController {

    private  final ParserService parserService;
    private  final MessageMapper messageMapper;

    public ParserController(ParserService parserService, MessageMapper messageMapper) {
        this.parserService = parserService;
        this.messageMapper = messageMapper;
    }

    @PostMapping("/date")
    public List<DtoMessage> getDataByDate(@RequestParam Integer date) {
      return messageMapper.toDto(parserService.dataByDate(date));
    }
}
