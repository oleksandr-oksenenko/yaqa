package com.yaqa.dao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "comments")
public class CommentEntity {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String body;

    @NotNull
    @ManyToOne
    private QuestionEntity question;

    @NotNull
    @ManyToOne
    private UserEntity author;

    @OneToMany
    private List<LikeEntity> likes;

    /**
     * Default constructor that is used by hibernate.
     */
    public CommentEntity() {
    }

    public CommentEntity(String body, UserEntity author, QuestionEntity question) {
        this.body = body;
        this.author = author;
        this.question = question;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    public List<LikeEntity> getLikes() {
        return likes;
    }

    public void setLikes(List<LikeEntity> likes) {
        this.likes = likes;
    }

    public QuestionEntity getQuestion() {
        return question;
    }

    public void setQuestion(QuestionEntity question) {
        this.question = question;
    }
}