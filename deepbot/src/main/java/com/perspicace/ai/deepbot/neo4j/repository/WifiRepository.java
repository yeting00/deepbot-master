package com.perspicace.ai.deepbot.neo4j.repository;


import com.perspicace.ai.deepbot.domain.Wifi;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface WifiRepository extends Neo4jRepository<Wifi,Long> {
}
