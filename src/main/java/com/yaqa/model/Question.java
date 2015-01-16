package com.yaqa.model;

import com.yaqa.dao.entity.QuestionEntity;
import org.joda.time.LocalDateTime;

import java.util.List;
import java.util.stream.Collectors;

public class Question {
    private final Long id;
    private final String title;
    private final String body;
    private final LocalDateTime creationDate;
    private final User author;
    private final List<Tag> tags;

    public static Question of(QuestionEntity questionEntity) {
        return new Question(
                questionEntity.getId(),
                questionEntity.getTitle(),
                questionEntity.getBody(),
                questionEntity.getCreationDate(),
                User.of(questionEntity.getAuthor()),
                questionEntity.getTags().stream().map(Tag::of).collect(Collectors.toList())
        );
    }

    public Question(Long id, String title, String body, LocalDateTime creationDate, User author, List<Tag> tags) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.creationDate = creationDate;
        this.author = author;
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public User getAuthor() {
        return author;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }
}
