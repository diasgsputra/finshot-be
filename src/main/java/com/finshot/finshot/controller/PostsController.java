package com.finshot.finshot.controller;

import com.finshot.finshot.entity.Posts;
import com.finshot.finshot.request.PostsRequest;
import com.finshot.finshot.response.PostsResponse;
import com.finshot.finshot.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/posts")
public class PostsController {

  @Autowired
  private PostsService postsService;

  @PostMapping
  public ResponseEntity<String> createUser(@RequestBody PostsRequest postsRequest
  ) throws IOException {
    postsService.createPost(postsRequest);
    return ResponseEntity.ok("Post created succesfully");
  }

  @GetMapping
  public ResponseEntity<List<PostsResponse>> getAllPosts() {
    List<PostsResponse> posts = postsService.getAllPosts();
    return ResponseEntity.ok(posts);
  }

  @GetMapping("/{id}")
  public ResponseEntity<PostsResponse> getPostsById(@PathVariable Long id) {
    PostsResponse posts = postsService.getPostsById(id);
    return ResponseEntity.ok(posts);
  }
  @PutMapping("/{id}")
  public ResponseEntity<String> updateUser(@PathVariable Long id,
                                         @RequestBody PostsRequest postsRequest) throws IOException {
    postsService.updatePost(id,postsRequest);
    return ResponseEntity.ok("Updated successfully");
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteUser(@PathVariable Long id,
                                           @RequestParam(name="password") String password) {
    postsService.deletePost(id, password);
    return ResponseEntity.ok("Deleted successfully");
  }
}

