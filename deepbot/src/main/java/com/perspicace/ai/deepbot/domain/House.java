package com.perspicace.ai.deepbot.domain;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.DateLong;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@NodeEntity(label = "House")
public class House {
    @Id
    @GeneratedValue
    private Long id;
    private long sqlID;
    private String name;
    private String enName;
    private String key;
    private String nick_name;
    private String province;
    private String city;            //市
    private String district;        //区域
    private int floor;              //楼层
    private String location;        //具体地址
    private int floorNum;           //家庭楼层数量
    private int size;
    @DateLong
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date create;


    @Relationship(type = "FAMILY_MEMBER",direction = Relationship.OUTGOING)
    private Set<Person> family_member = new HashSet<Person>();

    @Relationship(type = "VISTOR",direction = Relationship.OUTGOING)
    private Set<Person> vistors= new HashSet<Person>();

    @Relationship(type = "HOUSE_FLOOR", direction = Relationship.OUTGOING)
    private Set<Floor> house_floor = new HashSet<Floor>();

    public House() {
    }

    public Set<Person> getFamily_member() {
        return family_member;
    }

    public void setFamily_member(Set<Person> family_member) {
        this.family_member = family_member;
    }

    public Set<Floor> getHouse_floor() {
        return house_floor;
    }

    public void setHouse_floor(Set<Floor> house_floor) {
        this.house_floor = house_floor;
    }

    public void addFamilyMember(Person person)
    {
        family_member.add(person);
    }

    public void addVistor(Person person)
    {
        vistors.add(person);
    }

    public void addFloor(Floor floor)
    {
        house_floor.add(floor);
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(int floorNum) {
        this.floorNum = floorNum;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }

    public Set<Person> getVistors() {
        return vistors;
    }

    public void setVistors(Set<Person> vistors) {
        this.vistors = vistors;
    }
}
