package com.finshot.finshot.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name = "posts")
public class Posts {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "post_id")
  private Long postId;
  private String title;
  @Column(name = "author_name")
  private String authorName;
  private String content;
  @Column(name = "password_hash")
  private String passwordHash;
  private Long views;
  @Column(name = "created_at")
  private Date createdAt;
  @Column(name = "updated_at")
  private Date updatedAt;
  @Column(name = "is_deleted")
  private Boolean isDeleted;

  public void setPostId(Long postId) {
    this.postId = postId;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setAuthorName(String authorName) {
    this.authorName = authorName;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public void setPasswordHash(String passwordHash) {
    this.passwordHash = passwordHash;
  }

  public void setViews(Long views) {
    this.views = views;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  public void setIsDeleted(Boolean deleted) {
    isDeleted = deleted;
  }

  public Long getPostId() {
    return postId;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthorName() {
    return authorName;
  }

  public String getContent() {
    return content;
  }

  public String getPasswordHash() {
    return passwordHash;
  }

  public Long getViews() {
    return views;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public Boolean getIsDeleted() {
    return isDeleted;
  }
}

