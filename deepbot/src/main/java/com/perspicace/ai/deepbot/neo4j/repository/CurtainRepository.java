package com.perspicace.ai.deepbot.neo4j.repository;


import com.perspicace.ai.deepbot.domain.Curtain;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CurtainRepository extends Neo4jRepository<Curtain,Long> {
}
