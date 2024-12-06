package com.finshot.finshot.service;

import com.finshot.finshot.entity.Posts;
import com.finshot.finshot.request.PostsRequest;
import com.finshot.finshot.response.PostsResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface PostsService {
  List<PostsResponse> getAllPosts();
  PostsResponse getPostsById(Long id);
  void createPost(PostsRequest postsRequest);
  void updatePost(Long id, PostsRequest postsRequest);
  void deletePost(Long id, String password);
}
