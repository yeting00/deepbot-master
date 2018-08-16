package com.perspicace.ai.deepbot.domain;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class Floor {
    @Id
    @GeneratedValue
    private Long id;
    private long sqlID;
    private String name;
    private String enName;
    private String key;
    private String nick_name;
    private int size;

    @Relationship(type = "HOME_REGION",direction = Relationship.OUTGOING)
    private Set<Homeregion> homeregions = new HashSet<Homeregion>();

    public Set<Homeregion> getHomeregions() {
        return homeregions;
    }

    public void setHomeregions(Set<Homeregion> homeregions) {
        this.homeregions = homeregions;
    }

    public void addHomeRegion(Homeregion homeregion){
        homeregions.add(homeregion);
    }

    public Floor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
