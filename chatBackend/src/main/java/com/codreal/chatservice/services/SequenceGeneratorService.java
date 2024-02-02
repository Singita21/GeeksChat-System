package com.codreal.chatservice.services;

import com.codreal.chatservice.model.DatabaseSequence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class SequenceGeneratorService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public int generateSequence(String seqName) {
        DatabaseSequence counter = entityManager.find(DatabaseSequence.class, seqName);

        if (counter == null) {
            counter = new DatabaseSequence(seqName, 1);
            entityManager.persist(counter);
        } else {
            counter.setSeq(counter.getSeq() + 1);
            entityManager.merge(counter);
        }

        return counter.getSeq();
    }
}
