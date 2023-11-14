package com.sai.pokerplanning.pokersessionservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sai.pokerplanning.pokersessionservice.model.PokerSession;
import com.sai.pokerplanning.pokersessionservice.model.PokerSessionMember;
import com.sai.pokerplanning.pokersessionservice.repository.PokerSessionMemberRepository;
import com.sai.pokerplanning.pokersessionservice.repository.PokerSessionRepository;

@Service
	public class PokerSessionService {

	    private final PokerSessionRepository sessionRepository;
	    private final PokerSessionMemberRepository memberRepository;

	    @Autowired
	    public PokerSessionService(PokerSessionRepository sessionRepository, PokerSessionMemberRepository memberRepository) {
	        this.sessionRepository = sessionRepository;
	        this.memberRepository = memberRepository;
	    }

	    public PokerSession createSession(PokerSession session) {
	        return sessionRepository.save(session);
	    }

	    public <S> PokerSessionMember createMember(PokerSessionMember member) {
	        return memberRepository.save(member);
	    }

	    public Optional<PokerSession> getMembersBySessionId(Long sessionId) {
	        return memberRepository.findById(sessionId);
	    }

	    public PokerSession getSessionById(Long sessionId) {
	        return sessionRepository.findById(sessionId).orElse(null);
	    }

	    public List<PokerSession> getAllSessions() {
	        return sessionRepository.findAll();
	    }

	    public PokerSession updateSession(Long sessionId, PokerSession updatedSession) {
	        // Ensure the session exists before updating
	        PokerSession existingSession = getSessionById(updatedSession.getId());
	        if (existingSession == null) {
	            return null; // Session not found
	        }

	        // Update the session's properties
	        existingSession.setTitle(updatedSession.getTitle());
	        existingSession.setDeckType(updatedSession.getDeckType());

	        return sessionRepository.save(existingSession);
	    }

	    public boolean deleteSession(Long sessionId) {
	        // Delete the session
	        sessionRepository.deleteById(sessionId);

	        // Delete all members associated with the session
	        memberRepository.deleteById(sessionId);
			return false;
	    }

		public <UserStory> PokerSession addUserStoryToSession(Long sessionId, UserStory userStory) {
			// TODO Auto-generated method stub
			return null;
		}

		public PokerSessionMember createMember(PokerSessionMember member, Long sessionId) {
			// TODO Auto-generated method stub
			return null;
		}



		
	}

