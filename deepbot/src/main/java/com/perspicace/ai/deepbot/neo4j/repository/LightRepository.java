package com.perspicace.ai.deepbot.neo4j.repository;


import com.perspicace.ai.deepbot.domain.Light;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface LightRepository extends Neo4jRepository<Light,Long> {

}
