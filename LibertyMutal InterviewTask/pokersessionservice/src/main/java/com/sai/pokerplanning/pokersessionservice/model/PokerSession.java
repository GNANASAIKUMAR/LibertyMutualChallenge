package com.sai.pokerplanning.pokersessionservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PokerSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String deckType;

    // Constructors
    public PokerSession() {
        // Default constructor
    }

    public PokerSession(String title, String deckType) {
        this.title = title;
        this.deckType = deckType;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeckType() {
        return deckType;
    }

    public void setDeckType(String deckType) {
        this.deckType = deckType;
    }

    @Override
    public String toString() {
        return "PokerSession{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", deckType='" + deckType + '\'' +
                '}';
    }
}

