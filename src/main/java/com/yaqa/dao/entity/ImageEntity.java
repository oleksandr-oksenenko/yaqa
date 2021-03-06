package com.yaqa.dao.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "images")
public class ImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "imagesIdSequence")
    @SequenceGenerator(name = "imagesIdSequence", sequenceName = "IMAGES_ID_SEQ")
    private Long id;

    @NotNull
    private String contentType;

    @Basic(fetch = FetchType.LAZY)
    @Lob
    @NotNull
    private byte[] content;

    @ManyToOne(fetch = FetchType.LAZY)
    private QuestionEntity question;

    @ManyToOne(fetch = FetchType.LAZY)
    private CommentEntity comment;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;

    /**
     * Supposed to be used only by hibernate.
     */
    @Deprecated
    public ImageEntity() {
    }

    public ImageEntity(byte[] content, String contentType) {
        this.content = content;
        this.contentType = contentType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public QuestionEntity getQuestion() {
        return question;
    }

    public void setQuestion(QuestionEntity question) {
        this.question = question;
    }

    public CommentEntity getComment() {
        return comment;
    }

    public void setComment(CommentEntity comment) {
        this.comment = comment;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
