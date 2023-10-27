package com.example.telegramparser.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="type")
    private String type;
    @Column(name="date")
    private Integer date;
    @Column(name="edited")
    private Integer edited;
    @Column(name="from_id")
    private Long fromId;
    @Column(name="text")
    private String text;
}
