package com.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.post.entity.Comments;

@Repository
public interface CommentRepo extends JpaRepository<Comments, Long> {

}