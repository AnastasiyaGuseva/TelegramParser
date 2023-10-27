package com.example.telegramparser.utils;

import com.example.telegramparser.dto.DtoMessage;
import com.example.telegramparser.model.Message;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    List<Message> toEntity(List<DtoMessage> dto);

    List<DtoMessage> toDto(List<Message> message);

}
