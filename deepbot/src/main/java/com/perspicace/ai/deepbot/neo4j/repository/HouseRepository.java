package com.perspicace.ai.deepbot.neo4j.repository;


import com.perspicace.ai.deepbot.domain.House;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface HouseRepository extends Neo4jRepository<House,Long> {
}
