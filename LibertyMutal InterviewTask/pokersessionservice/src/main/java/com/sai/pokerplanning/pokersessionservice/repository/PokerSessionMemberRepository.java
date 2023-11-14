package com.sai.pokerplanning.pokersessionservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sai.pokerplanning.pokersessionservice.model.PokerSession;
import com.sai.pokerplanning.pokersessionservice.model.PokerSessionMember;

@Repository
public interface PokerSessionMemberRepository extends JpaRepository<PokerSession, Long> {

	PokerSessionMember save(PokerSessionMember member);
}

