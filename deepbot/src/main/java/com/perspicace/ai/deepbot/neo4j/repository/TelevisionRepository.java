package com.perspicace.ai.deepbot.neo4j.repository;


import com.perspicace.ai.deepbot.domain.Television;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface TelevisionRepository extends Neo4jRepository<Television,Long> {
}
