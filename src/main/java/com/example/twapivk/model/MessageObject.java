package com.example.twapivk.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MessageObject {

    @JsonProperty("from_id")
    private int fromId;

    @JsonProperty("text")
    private String text;
}
