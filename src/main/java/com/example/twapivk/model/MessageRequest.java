package com.example.twapivk.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MessageRequest {
    @JsonProperty("type")
    private String type;

    @JsonProperty("event_id")
    private int eventID;

    @JsonProperty("v")
    private String v;

    @JsonProperty("object")
    private MessageObject object;

    @JsonProperty("group_id")
    private int groupId;
}
