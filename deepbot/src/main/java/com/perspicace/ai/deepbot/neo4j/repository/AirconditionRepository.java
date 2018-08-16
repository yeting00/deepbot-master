package com.perspicace.ai.deepbot.neo4j.repository;

import com.perspicace.ai.deepbot.domain.AirConditioner;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface AirconditionRepository extends Neo4jRepository<AirConditioner,Long> {
}


