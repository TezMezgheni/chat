package com.mez.chat.controller;

import com.mez.chat.model.Message;
import com.mez.chat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping("/msg/{sender}/{receiver}")
    void send(@PathVariable String receiver, @PathVariable String sender, @RequestBody Message msg) {
        messageService.send(receiver, msg);
    }

    @GetMapping("/msg/{name}/read")
    Message read(@PathVariable String name) {
        return messageService.read(name);
    }

    @GetMapping("/msg/{name}/listen")
    Message listen(@PathVariable String name) {
        return messageService.listen(name);
    }

    @PostMapping("/msg/register")
    void register(@RequestParam String name) {
        messageService.register(name);
    }
}
