package com.example.twapivk.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "random_id")
    private Integer randomId;

    @Column(name = "message_text")
    private String messageText;

    @Column(name = "v")
    private String v;


    public Message(int userId, int randomId, String message, String v){
        this.v = v;
        this.userId = userId;
        this.messageText = message;
        this.randomId = randomId;
    }


}
