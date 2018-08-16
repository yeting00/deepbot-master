package com.perspicace.ai.deepbot.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.neo4j.ogm.annotation.*;
import org.neo4j.ogm.annotation.typeconversion.DateLong;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@RelationshipEntity(type = "RATED")
public class Rating{
    @Id
    @GeneratedValue
    private Long id;
    @StartNode
    @JsonBackReference
    private Person person;
    @EndNode
    @JsonBackReference
    private Movie movie;
    private int stars;
    private String comment;
    @DateLong
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date create;

    public Rating() {}

    public Rating(Person person, Movie movie, int stars, String comment) {
        this.person = person;
        this.movie = movie;
        this.stars = stars;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getStars() {
        return stars;
    }

    public String getComment() {
        return comment;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }
}
