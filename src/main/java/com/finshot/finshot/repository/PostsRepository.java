package com.finshot.finshot.repository;

import com.finshot.finshot.entity.Posts;
import com.finshot.finshot.response.PostsResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {
  @Query(value="select * from posts where is_deleted = false",nativeQuery = true)
  List<Posts> getAllPosts();

  @Query(value="select * from posts where post_id = :id",nativeQuery = true)
  Posts getPostById(Long id);

  @Query(nativeQuery = true, value = "SELECT NOW()")
  Timestamp getSysDate();
}

