package com.sai.pokerplanning.pokersessionservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PokerSessionMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long sessionId; // Reference to the session

    // Constructors
    public PokerSessionMember() {
        // Default constructor
    }

    public PokerSessionMember(String name, Long sessionId) {
        this.name = name;
        this.sessionId = sessionId;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public String toString() {
        return "PokerSessionMember{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sessionId=" + sessionId +
                '}';
    }
}
