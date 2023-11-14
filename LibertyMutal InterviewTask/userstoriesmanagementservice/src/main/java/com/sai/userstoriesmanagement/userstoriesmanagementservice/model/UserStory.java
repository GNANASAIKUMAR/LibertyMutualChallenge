package com.sai.userstoriesmanagement.userstoriesmanagementservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserStory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String status;
    private String assignee;
    
    public UserStory() {
        // Default constructor
    }

    public UserStory(String description, String status, String assignee) {
        this.description = description;
        this.status = status;
        this.assignee = assignee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }
    
    // Additional methods
    public void start() {
        this.status = "In Progress";
    }
    
    public void complete() {
        this.status = "Completed";
    }
    
    // Add more fields, getters, setters, and methods as needed
}
