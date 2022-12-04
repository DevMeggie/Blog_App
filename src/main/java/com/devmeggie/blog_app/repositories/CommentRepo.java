package com.devmeggie.blog_app.repositories;

import com.devmeggie.blog_app.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepo extends JpaRepository<Comment,Long> {
   // List<Comment> findCommentsByPostId(long postId);
}
