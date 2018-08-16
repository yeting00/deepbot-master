package com.perspicace.ai.deepbot.neo4j.repository;


import com.perspicace.ai.deepbot.domain.Cinema;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CinemaRepository extends Neo4jRepository<Cinema,Long> {
}


