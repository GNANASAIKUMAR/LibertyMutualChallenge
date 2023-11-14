package com.sai.votesmanagement.votesmanagementservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sai.votesmanagement.votesmanagementservice.model.UserStory;
import com.sai.votesmanagement.votesmanagementservice.repository.UserStoryRepository;

@Service
public class UserStoryService {

    @Autowired
    private UserStoryRepository userStoryRepository;

    public UserStory create(UserStory userStory) {
        userStory.setStatus("PENDING");
        return userStoryRepository.save(userStory);
    }

    public UserStory vote(Long userStoryId, String voteValue) {
        UserStory userStory = userStoryRepository.findById(userStoryId).orElse(null);
        if (userStory != null && "VOTING".equals(userStory.getStatus())) {
            userStory.setStatus("VOTED");
            userStory.setVoteValue(voteValue);
            return userStoryRepository.save(userStory);
        }
        return null;
    }

    public List<UserStory> getPendingUserStories() {
        return userStoryRepository.findByStatus("PENDING");
    }

    public List<UserStory> getVotedUserStories() {
        return userStoryRepository.findByStatus("VOTED");
    }

    public List<UserStory> getAllUserStories() {
        return userStoryRepository.findAll();
    }

    public UserStory getUserStory(Long userStoryId) {
        return userStoryRepository.findById(userStoryId).orElse(null);
    }

    public boolean deleteUserStory(Long userStoryId) {
        if (userStoryRepository.existsById(userStoryId)) {
            userStoryRepository.deleteById(userStoryId);
            return true;
        }
        return false;
    }

    public UserStory update(UserStory updatedUserStory) {
        UserStory existingUserStory = userStoryRepository.findById(updatedUserStory.getId()).orElse(null);
        if (existingUserStory != null) {
            existingUserStory.setDescription(updatedUserStory.getDescription());
            existingUserStory.setStatus(updatedUserStory.getStatus());
            existingUserStory.setVoteValue(updatedUserStory.getVoteValue());
            return userStoryRepository.save(existingUserStory);
        }
        return null;
    }


    // Add more service methods for User Story management
}
