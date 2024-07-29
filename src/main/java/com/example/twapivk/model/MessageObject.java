package com.example.twapivk.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MessageObject {

    @JsonProperty("user_id")
    private int userId;

    @JsonProperty("message")
    private String message;
}
