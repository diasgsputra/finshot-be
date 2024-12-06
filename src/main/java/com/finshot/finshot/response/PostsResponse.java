package com.finshot.finshot.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.finshot.finshot.entity.Posts;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
public class PostsResponse {
  @JsonProperty("post_id")
  private Long postId;
  @JsonProperty("title")
  private String title;
  @JsonProperty("author_name")
  private String authorName;
  @JsonProperty("content")
  private String content;
  @JsonProperty("password_hash")
  private String passwordHash;
  @JsonProperty("views")
  private Long views;
  @JsonProperty("created_at")
  private String createdAt;
  @JsonProperty("updated_at")
  private String updatedAt;
  @JsonProperty("is_deleted")
  private Boolean isDeleted;

  public PostsResponse(Posts posts){
    this.postId = posts.getPostId();
    this.title = posts.getTitle();
    this.authorName = posts.getAuthorName();
    this.content = posts.getContent();
    this.passwordHash = posts.getPasswordHash();
    this.views = posts.getViews();
    this.createdAt = posts.getCreatedAt().toString();
    this.updatedAt = posts.getUpdatedAt().toString();
    this.isDeleted = posts.getIsDeleted();
  }
}
