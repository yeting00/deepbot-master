package com.perspicace.ai.deepbot.neo4j.repository;


import com.perspicace.ai.deepbot.domain.Homeregion;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface HomeRegionRepository extends Neo4jRepository<Homeregion,Long> {

}
