package com.devmeggie.blog_app.controllers;

import com.devmeggie.blog_app.models.Comment;
import com.devmeggie.blog_app.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;
    @PostMapping("/{id}")
    public String makeComment(@PathVariable("id") Long postId, @RequestBody Comment comment){
        return commentService.makeComment(postId,comment);
    }
}
