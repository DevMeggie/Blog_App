package com.devmeggie.blog_app.services;

import com.devmeggie.blog_app.models.Comment;

public interface CommentService {
    String makeComment(Long postId, Comment comment);
}
