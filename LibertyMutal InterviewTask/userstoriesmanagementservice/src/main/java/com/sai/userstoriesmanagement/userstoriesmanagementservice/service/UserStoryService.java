package com.sai.userstoriesmanagement.userstoriesmanagementservice.service;

import com.sai.userstoriesmanagement.userstoriesmanagementservice.model.UserStory;
import com.sai.userstoriesmanagement.userstoriesmanagementservice.repository.UserStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserStoryService {

    @Autowired
    private UserStoryRepository userStoryRepository;

    public UserStory createUserStory(UserStory userStory) {
        // Add logic to create a new User Story and save it in the repository
        return userStoryRepository.save(userStory);
    }

    public List<UserStory> getAllUserStories() {
        // Add logic to retrieve all User Stories from the repository
        return userStoryRepository.findAll();
    }

    public UserStory getUserStoryById(Long userStoryId) {
        // Add logic to retrieve a User Story by ID from the repository
        Optional<UserStory> userStoryOptional = userStoryRepository.findById(userStoryId);
        return userStoryOptional.orElse(null);
    }

    public UserStory updateUserStory(Long userStoryId, UserStory updatedUserStory) {
        // Add logic to update an existing User Story
        // You can use the userStoryId to find the existing User Story and update its fields
        // Then save the updated User Story in the repository
        return userStoryRepository.save(updatedUserStory);
    }

    public boolean deleteUserStory(Long userStoryId) {
        // Add logic to delete a User Story by ID
        if (userStoryRepository.existsById(userStoryId)) {
            userStoryRepository.deleteById(userStoryId);
            return true;
        }
        return false;
    }

    public void startUserStory(Long userStoryId) {
        // Add logic to change the status of a User Story to "In Progress"
        UserStory userStory = getUserStoryById(userStoryId);
        if (userStory != null) {
            userStory.setStatus("In Progress");
            userStoryRepository.save(userStory);
        }
    }

    public void completeUserStory(Long userStoryId) {
        // Add logic to change the status of a User Story to "Completed"
        UserStory userStory = getUserStoryById(userStoryId);
        if (userStory != null) {
            userStory.setStatus("Completed");
            userStoryRepository.save(userStory);
        }
    }

    public List<UserStory> getUserStoriesByStatus(String status) {
        // Add logic to retrieve User Stories by status
        return userStoryRepository.findUserStoriesByStatus(status);
    }

    public List<UserStory> getUserStoriesByAssignee(String assignee) {
        // Add logic to retrieve User Stories by assignee
        return userStoryRepository.findUserStoriesByAssignee(assignee);
    }

    public List<UserStory> getPendingUserStories() {
        // Add logic to retrieve User Stories with a status of "Pending"
        return userStoryRepository.findUserStoriesByStatus("Pending");
    }

    // Add more service methods for User Story management as needed
}
