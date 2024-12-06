package com.finshot.finshot.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class PostsRequest {
  @JsonProperty("title")
  private String title;
  @JsonProperty("author_name")
  private String authorName;
  @JsonProperty("content")
  private String content;
  @JsonProperty("password")
  private String password;

  public String getTitle() {
    return title;
  }

  public String getAuthorName() {
    return authorName;
  }

  public String getContent() {
    return content;
  }

  public String getPassword() {
    return password;
  }
}
