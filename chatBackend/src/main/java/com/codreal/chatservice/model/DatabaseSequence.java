package com.codreal.chatservice.model;

import javax.persistence.*;

@Entity
@Table(name = "chats_database_sequences")
@SequenceGenerator(name = "seq_generator", sequenceName = "your_sequence_name", allocationSize = 1)
public class DatabaseSequence {

    @Id
    private String id;

    @Column(name = "seq")
    private int seq;

    public DatabaseSequence() {
    }

    public DatabaseSequence(String id, int seq) {
        this.id = id;
        this.seq = seq;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }
}
