package com.sai.userstoriesmanagement.userstoriesmanagementservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sai.userstoriesmanagement.userstoriesmanagementservice.model.UserStory;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface UserStoryRepository extends JpaRepository<UserStory, Long> {
    // Custom queries can be added here if needed

    // Example custom query to find User Stories by status
    @Query("SELECT u FROM UserStory u WHERE u.status = ?1")
    List<UserStory> findUserStoriesByStatus(String status);

	List<UserStory> findUserStoriesByAssignee(String assignee);
}
