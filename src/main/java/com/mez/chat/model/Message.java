package com.mez.chat.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Message {
    String sender;
    String receiver;
    String content;

}
