package com.example.twapivk.service;

import com.example.twapivk.model.Message;
import com.example.twapivk.model.MessageObject;
import com.example.twapivk.repository.MessageRepository;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class MessageService {

    @Value("${message.v}")
    private String v;

    @Value("${message.accessToken}")
    private String accessToken;

    private Random random;
    private final MessageRepository repository;

    public MessageService(MessageRepository repository) {
        this.repository = repository;
        this.random = new Random();
    }

    public void mirror(MessageObject messageObject, String secretKey)  {

        // Создаем объект класса Message
        Message message = new Message(messageObject.getFromId(),random.nextInt(),messageObject.getText(), v);

        //Создаем Post запрос
        final HttpPost httpPost = new HttpPost("https://api.vk.com/method/messages.send");

        // Добавляем параметры для запроса
        final List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("user_id", message.getUserId().toString()));
        params.add(new BasicNameValuePair("random_id", message.getRandomId().toString()));
        params.add(new BasicNameValuePair("message","Вы сказали: " + message.getMessageText()));
        params.add(new BasicNameValuePair("v", message.getV()));
        params.add(new BasicNameValuePair("access_token", accessToken));

        //Отправляем запрос
        try (CloseableHttpClient client = HttpClients.createDefault()){
            httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
            client.execute(httpPost);
        }catch (IOException e){
            e.getMessage();
        }

        repository.save(message);

    }
}
