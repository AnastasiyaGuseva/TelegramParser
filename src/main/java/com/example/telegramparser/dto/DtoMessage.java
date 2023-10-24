package com.example.telegramparser.dto;

import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DtoMessage {
    Integer id;
    String type;
    Integer date;
    Integer edited;
    String from;
    Long fromId;
    String text;
}
