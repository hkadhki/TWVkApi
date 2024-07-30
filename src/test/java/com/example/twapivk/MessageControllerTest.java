package com.example.twapivk;

import com.example.twapivk.controllers.MessageController;
import com.example.twapivk.model.Event;
import com.example.twapivk.model.MessageNew;
import com.example.twapivk.model.MessageObject;
import com.example.twapivk.service.MessageService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Objects;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class MessageControllerTest {
    @Mock
    private MessageService messageService;

    @InjectMocks
    private MessageController messageController;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(messageController).build();
        objectMapper = new ObjectMapper();
    }

    @PostMapping("/")
    void send() throws Exception {
        Event event = new Event("message_new",new MessageNew(new MessageObject(21124412,"текст")),1234567,"");
        String eventJsonn = objectMapper.writeValueAsString(event);
        mockMvc.perform(post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(eventJsonn)).andExpect(status().isOk());
        verify(messageService, times(1)).mirror(event.getObject().getMessageObject(),"");
    }
}
