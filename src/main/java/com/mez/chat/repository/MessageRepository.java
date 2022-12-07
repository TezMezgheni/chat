package com.mez.chat.repository;

import com.mez.chat.model.Message;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Repository
public class MessageRepository {
    HashMap<String, BlockingQueue<Message>> messageMap = new HashMap<>();
    public BlockingQueue<Message> findByName(String name) {
        return messageMap.get(name);

    }
    public void updateMessage(String sender,String receiver,String content){
        messageMap.get(receiver).add(new Message(sender,receiver, content));
    }

    public void addReceiver(String name) {
        BlockingQueue<Message> messageQueue = new LinkedBlockingQueue<>();
        messageMap.put(name, messageQueue);
    }
}
