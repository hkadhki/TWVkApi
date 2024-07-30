package com.example.twapivk.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Event {
    @JsonProperty("type")
    private String type;

    @JsonProperty("object")
    private MessageNew object;

    @JsonProperty("group_id")
    private int groupId;

    @JsonProperty("secret")
    private String secretKey;
}
