package com.perspicace.ai.deepbot.domain;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * @program: deepbot
 * @description: 汽车节点
 * @author: Destiny
 * @create: 2018-07-05 23:05
 **/
@NodeEntity(label = "Car")
public class Car {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String enName;
    private String key;
    private String nick_name;
    private long sqlID;
    private String city;
    private int capacity;

}
