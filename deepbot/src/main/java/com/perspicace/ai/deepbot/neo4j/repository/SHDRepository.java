package com.perspicace.ai.deepbot.neo4j.repository;


import com.perspicace.ai.deepbot.domain.Homeregion;
import com.perspicace.ai.deepbot.domain.SHD;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;


public interface SHDRepository extends Neo4jRepository<SHD,Long> {
    @Query("MATCH (n:SHD) WHERE ID(n) <> {id} RETURN n;")
    Iterable<SHD> findByIdNot(@Param("id") Long id);

    SHD findByName(String name);

    @Query("MATCH (n:SHD) WHERE n.devID = {dev_id} RETURN n")
    SHD findSHDByDevID(@Param("dev_id") String dev_id);

    // 根据墙机ID找到墙机所属区域
    @Query("MATCH (o:SHD) <-[:SHD_DEVICE]-(n:HomeRegion)  WHERE o.devID = {dev_id} RETURN n")
    Homeregion findHomeRegion(@Param("dev_id") String dev_id);



//    @Query("MATCH (n:HomeDevice) WHERE n.name ={dev_name} RETURN n" )
//    Iterable<HomeDevice> findHomeDevice(@Param("dev_name") String dev_name);

}
