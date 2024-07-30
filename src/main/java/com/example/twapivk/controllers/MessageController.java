package com.example.twapivk.controllers;

import com.example.twapivk.model.Event;
import com.example.twapivk.service.MessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

@RestController
public class MessageController {

    private final MessageService service;

    @Value("${message.secretKey}")
    private String secret;

    @Value("${message.returnString}")
    private String returnString;



    public MessageController(MessageService service) {
        this.service = service;
    }

    @PostMapping("/callback/api")
    public ResponseEntity callback(@RequestBody Event event) throws URISyntaxException, UnsupportedEncodingException {

        // проверка адреса для Callback api
        if(event.getType().equals("confirmation")){
            return new ResponseEntity(returnString, HttpStatus.OK);
        }

        // проверка типа события
        if(event.getType().equals("message_new")){

            //проверка секретного ключа или его отсутствие
            if (secret.equals(event.getSecretKey()) || (secret.equals("None") && event.getSecretKey() == null)){
                service.mirror(event.getObject().getMessageObject(), event.getSecretKey());
                return new ResponseEntity("ok", HttpStatus.OK);
            }
        }

        // если тип события не совпадает отправляем 405 Method Not Allowed
        return ResponseEntity.status(405).build();
    }
}
