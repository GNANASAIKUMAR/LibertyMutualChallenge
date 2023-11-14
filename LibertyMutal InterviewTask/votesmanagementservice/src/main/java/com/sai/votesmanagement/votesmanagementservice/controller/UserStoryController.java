package com.sai.votesmanagement.votesmanagementservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sai.votesmanagement.votesmanagementservice.model.UserStory;
import com.sai.votesmanagement.votesmanagementservice.service.UserStoryService;
import com.sai.votesmanagement.votesmanagementservice.repository.*;

@RestController
@RequestMapping("/user-stories")
public class UserStoryController {

    @Autowired
    private UserStoryService userStoryService;

    @PostMapping("/create")
    public ResponseEntity<UserStory> createUserStory(@RequestBody UserStory userStory) {
        UserStory createdUserStory = userStoryService.create(userStory);
        return ResponseEntity.ok(createdUserStory);
    }

    @PostMapping("/{userStoryId}/vote")
    public ResponseEntity<String> voteUserStory(@PathVariable Long userStoryId, @RequestParam String voteValue) {
        UserStory votedUserStory = userStoryService.vote(userStoryId, voteValue);
        if (votedUserStory != null) {
            return ResponseEntity.ok("Vote successful for User Story with ID: " + userStoryId);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot vote on this user story.");
        }
    }


    @GetMapping("/pending")
    public ResponseEntity<List<UserStory>> getPendingUserStories() {
        List<UserStory> pendingUserStories = userStoryService.getPendingUserStories();
        return ResponseEntity.ok(pendingUserStories);
    }

    @GetMapping("/voted")
    public ResponseEntity<List<UserStory>> getVotedUserStories() {
        List<UserStory> votedUserStories = userStoryService.getVotedUserStories();
        return ResponseEntity.ok(votedUserStories);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserStory>> getAllUserStories() {
        List<UserStory> allUserStories = userStoryService.getAllUserStories();
        return ResponseEntity.ok(allUserStories);
    }

    @GetMapping("/{userStoryId}")
    public ResponseEntity<UserStory> getUserStory(@PathVariable Long userStoryId) {
        UserStory userStory = userStoryService.getUserStory(userStoryId);
        if (userStory != null) {
            return ResponseEntity.ok(userStory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{userStoryId}")
    public ResponseEntity<?> deleteUserStory(@PathVariable Long userStoryId) {
        boolean deleted = userStoryService.deleteUserStory(userStoryId);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Add more controller methods for User Story management
}

