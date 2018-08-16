package com.perspicace.ai.deepbot.domain;


import com.google.gson.annotations.SerializedName;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author destiny
 */
@NodeEntity
public class Person implements Serializable {
	@Id
	@GeneratedValue
	private Long ID;
    private String userID;
	@SerializedName("Name")     //在转换为json格式后变为大写的Name
	private String name;
    private String enName;
    private String nickName="xxxx";
    private String key;
	private double age;
	private int gender;
	private String school;
	private boolean hasGirlfriend;
	private boolean isMarried;
	private String job;
	private String birthday = "1997-01-01T00:00:00";
	private String[] tagging;  	//人物标签
	private String[] hobby;
	private int weight;		//体重
	private String location = "上海"; 	//位置
	private int healthy = 0;	// 0 健康， 1 亚健康，2非健康
	private String identity = "123456789";	// 身份证


	@Relationship(type = "ACTED_IN")
	private List<Movie> movies = new ArrayList<>();

	public Person() {
	}

	public Person(String name , double age , int gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }


    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public boolean isHasGirlfriend() {
        return hasGirlfriend;
    }

    public void setHasGirlfriend(boolean hasGirlfriend) {
        this.hasGirlfriend = hasGirlfriend;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public void setMarried(boolean married) {
        isMarried = married;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String[] getTagging() {
        return tagging;
    }

    public void setTagging(String[] tagging) {
        this.tagging = tagging;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}