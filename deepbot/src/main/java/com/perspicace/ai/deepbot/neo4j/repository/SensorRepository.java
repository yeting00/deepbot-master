package com.perspicace.ai.deepbot.neo4j.repository;


import com.perspicace.ai.deepbot.domain.Sensor;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface SensorRepository extends Neo4jRepository<Sensor,Long> {
}
