package com.trl.libraryservice.repository.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity(name = "CommentEntity")
@Table(name = "comment_book")
public class CommentBookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private UserEntity user;

    @Column(name = "test", nullable = false)
    private String text;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @OneToMany(mappedBy = "commentBookEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SubCommentCommentEntity> subCommentCommentEntities;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private BookEntity bookEntity;

    public CommentBookEntity() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<SubCommentCommentEntity> getSubCommentCommentEntities() {
        return subCommentCommentEntities;
    }

    public void setSubCommentCommentEntities(List<SubCommentCommentEntity> subCommentCommentEntities) {
        this.subCommentCommentEntities = subCommentCommentEntities;
    }

    public BookEntity getBookEntity() {
        return bookEntity;
    }

    public void setBookEntity(BookEntity bookEntity) {
        this.bookEntity = bookEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentBookEntity that = (CommentBookEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(user, that.user) &&
                Objects.equals(text, that.text) &&
                Objects.equals(date, that.date) &&
                Objects.equals(subCommentCommentEntities, that.subCommentCommentEntities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, text, date, subCommentCommentEntities);
    }

    @Override
    public String toString() {
        return "CommentBookEntity{" +
                "id=" + id +
                ", user=" + user +
                ", text='" + text + '\'' +
                ", date=" + date +
                ", subComments=" + subCommentCommentEntities +
                '}';
    }
}
