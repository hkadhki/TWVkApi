package com.example.twapivk.repository;

import com.example.twapivk.model.Message;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class MessageRepository {

    @PersistenceContext
    private EntityManager manager;

    public void save(Message message){
        manager.persist(message);
    }
}
