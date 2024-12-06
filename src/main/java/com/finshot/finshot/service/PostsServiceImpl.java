package com.finshot.finshot.service;

import com.finshot.finshot.entity.Posts;
import com.finshot.finshot.exception.BadRequestException;
import com.finshot.finshot.repository.PostsRepository;
import com.finshot.finshot.request.PostsRequest;
import com.finshot.finshot.response.PostsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.time.LocalDateTime;

@Service
public class PostsServiceImpl implements PostsService {
  @Autowired
  private PostsRepository postsRepository;

  private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  @Override
  public List<PostsResponse> getAllPosts(){
    List<Posts> postsList = postsRepository.getAllPosts();
    List<PostsResponse> postsResponse = postsList.stream().map(PostsResponse::new).collect(Collectors.toList());
    return postsResponse;
  }

  @Override
  public PostsResponse getPostsById(Long id){
    Posts post = postsRepository.getPostById(id);
    post.setViews(post.getViews()+1);
    postsRepository.save(post);
    return new PostsResponse(post);
  }

  @Override
  public void createPost(PostsRequest postsRequest){
    Timestamp sys = postsRepository.getSysDate();
    Posts post = new Posts();
    post.setAuthorName(postsRequest.getAuthorName());
    post.setContent(postsRequest.getContent());
    post.setTitle(postsRequest.getTitle());
    post.setPasswordHash(passwordEncoder.encode(postsRequest.getPassword()));
    post.setIsDeleted(false);
    post.setViews(0L);
    post.setCreatedAt(sys); // Set createdAt
    post.setUpdatedAt(sys);
    postsRepository.save(post);
  }

  @Override
  public void updatePost(Long id, PostsRequest postsRequest){
    Timestamp sys = postsRepository.getSysDate();
    Posts post = postsRepository.getPostById(id);
    if(!passwordEncoder.matches(postsRequest.getPassword(), post.getPasswordHash())){
      throw new BadRequestException("Wrong passwword");
    }
    post.setAuthorName(postsRequest.getAuthorName());
    post.setContent(postsRequest.getContent());
    post.setTitle(postsRequest.getTitle());
    post.setUpdatedAt(sys);
    post.setIsDeleted(false);
    postsRepository.save(post);
  }

  @Override
  public void deletePost(Long id, String password){
    Timestamp sys = postsRepository.getSysDate();
    Posts post = postsRepository.getPostById(id);
    if(!passwordEncoder.matches(password, post.getPasswordHash())){
      throw new BadRequestException("Wrong passwword");
    }
    post.setIsDeleted(true);
    post.setUpdatedAt(sys);
    postsRepository.save(post);
  }
}
