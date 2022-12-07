package com.mez.chat.service;

import com.mez.chat.model.Message;
import com.mez.chat.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    public void send(String receiver, Message message) {
        if (messageRepository.findByName(receiver) == null) {
            messageRepository.addReceiver(receiver);
        }
        messageRepository.updateMessage(message.getSender(), message.getReceiver(), message.getContent());
    }

    public void register(String name) throws RuntimeException {
        if (messageRepository.findByName(name) == null) {
            throw new RuntimeException();
        }
        messageRepository.addReceiver(name);
    }

    public Message listen(String name) {
        try {
            return messageRepository.findByName(name).take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Message read(String name) {
        return messageRepository.findByName(name).poll();
    }
}
