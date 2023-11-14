package com.sai.userstoriesmanagement.userstoriesmanagementservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sai.userstoriesmanagement.userstoriesmanagementservice.model.UserStory;
import com.sai.userstoriesmanagement.userstoriesmanagementservice.service.UserStoryService;

@RestController
@RequestMapping("/user-stories")
public class UserStoriesController {

    @Autowired
    private UserStoryService userStoryService;

    // Create a new User Story
    @PostMapping("/create")
    public ResponseEntity<UserStory> createUserStory(@RequestBody UserStory userStory) {
        UserStory createdUserStory = userStoryService.createUserStory(userStory);
        return ResponseEntity.ok(createdUserStory);
    }

    // Get all User Stories
    @GetMapping("/all")
    public ResponseEntity<List<UserStory>> getAllUserStories() {
        List<UserStory> userStories = userStoryService.getAllUserStories();
        return ResponseEntity.ok(userStories);
    }

    // Get a specific User Story by its ID
    @GetMapping("/{userStoryId}")
    public ResponseEntity<UserStory> getUserStory(@PathVariable Long userStoryId) {
        UserStory userStory = userStoryService.getUserStoryById(userStoryId);
        if (userStory != null) {
            return ResponseEntity.ok(userStory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update an existing User Story
    @PutMapping("/update/{userStoryId}")
    public ResponseEntity<UserStory> updateUserStory(
            @PathVariable Long userStoryId,
            @RequestBody UserStory updatedUserStory) {
        UserStory userStory = userStoryService.updateUserStory(userStoryId, updatedUserStory);
        if (userStory != null) {
            return ResponseEntity.ok(userStory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a User Story by its ID
    @DeleteMapping("/delete/{userStoryId}")
    public ResponseEntity<String> deleteUserStory(@PathVariable Long userStoryId) {
        if (userStoryService.deleteUserStory(userStoryId)) {
            return ResponseEntity.ok("User Story deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Add more controller methods for User Story management

    // You can continue to add other endpoints as needed, based on your application's requirements.
}
