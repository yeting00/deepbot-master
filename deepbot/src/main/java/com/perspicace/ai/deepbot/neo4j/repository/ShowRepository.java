package com.perspicace.ai.deepbot.neo4j.repository;


import com.perspicace.ai.deepbot.domain.Show;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ShowRepository extends Neo4jRepository<Show,Long> {
}