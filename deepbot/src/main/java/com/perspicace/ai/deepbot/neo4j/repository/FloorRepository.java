package com.perspicace.ai.deepbot.neo4j.repository;


import com.perspicace.ai.deepbot.domain.Floor;
import org.springframework.data.neo4j.repository.Neo4jRepository;


public interface FloorRepository extends Neo4jRepository<Floor,Long> {
}
