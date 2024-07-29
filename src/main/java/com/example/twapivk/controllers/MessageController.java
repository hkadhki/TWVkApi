package com.example.twapivk.controllers;

import com.example.twapivk.model.MessageObject;
import com.example.twapivk.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

@RestController
public class MessageController {

    private final MessageService service;

    public MessageController(MessageService service) {
        this.service = service;
    }

    //@RequestBody MessageRequest messageRequest
    @GetMapping("/send")
    public ResponseEntity send() throws URISyntaxException, UnsupportedEncodingException {
        service.send(new MessageObject(196057466,"1ыв11qa"));
        return ResponseEntity.ok().build();
    }
}
