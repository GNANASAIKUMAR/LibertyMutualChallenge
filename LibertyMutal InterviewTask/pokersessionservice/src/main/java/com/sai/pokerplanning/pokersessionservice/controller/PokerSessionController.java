package com.sai.pokerplanning.pokersessionservice.controller;

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

import com.sai.pokerplanning.pokersessionservice.model.PokerSession;
import com.sai.pokerplanning.pokersessionservice.model.PokerSessionMember;
import com.sai.pokerplanning.pokersessionservice.service.PokerSessionService;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/sessions")
public class PokerSessionController {

    @Autowired
    private PokerSessionService sessionService;

    @PostMapping("/create")
    public ResponseEntity<PokerSession> createSession(@RequestBody PokerSession session) {
        PokerSession createdSession = sessionService.createSession(session);
        return ResponseEntity.ok(createdSession);
    }

    @GetMapping("/{sessionId}")
    public ResponseEntity<PokerSession> getSession(@PathVariable Long sessionId) {
        PokerSession session = sessionService.getSessionById(sessionId);
        if (session != null) {
            return ResponseEntity.ok(session);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{sessionId}/members")
    public ResponseEntity<PokerSessionMember> addMemberToSession(@PathVariable Long sessionId, @RequestBody PokerSessionMember member) {
        PokerSessionMember createdMember = sessionService.createMember(member, sessionId);
        return ResponseEntity.ok(createdMember);
    }

    @GetMapping("/{sessionId}/members")
    public ResponseEntity<Optional<PokerSession>> getMembersBySessionId(@PathVariable Long sessionId) {
        Optional<PokerSession> members = sessionService.getMembersBySessionId(sessionId);
        return ResponseEntity.ok(members);
    }

    @DeleteMapping("/{sessionId}")
    public ResponseEntity<?> deleteSession(@PathVariable Long sessionId) {
        boolean deleted = sessionService.deleteSession(sessionId);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{sessionId}")
    public ResponseEntity<PokerSession> updateSession(@PathVariable Long sessionId, @RequestBody PokerSession updatedSession) {
        PokerSession updated = sessionService.updateSession(sessionId, updatedSession);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<PokerSession>> getAllSessions() {
        List<PokerSession> sessions = sessionService.getAllSessions();
        return ResponseEntity.ok(sessions);
    }

 

        @PostMapping("/{sessionId}/add-story")
        public <UserStory> ResponseEntity<PokerSession> addStoryToSession(@PathVariable Long sessionId, @RequestBody UserStory userStory) {
            PokerSession updatedSession = sessionService.addUserStoryToSession(sessionId, userStory);
            if (updatedSession != null) {
                return ResponseEntity.ok(updatedSession);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

  

}
