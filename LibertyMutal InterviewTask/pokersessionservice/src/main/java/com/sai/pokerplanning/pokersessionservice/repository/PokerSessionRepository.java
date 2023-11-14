package com.sai.pokerplanning.pokersessionservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sai.pokerplanning.pokersessionservice.model.PokerSession;

@Repository
public interface PokerSessionRepository extends JpaRepository<PokerSession, Long> {
}

