package com.devmeggie.blog_app.controllers;

import com.devmeggie.blog_app.dtos.UpLoadPostDto;
import com.devmeggie.blog_app.models.Post;
import com.devmeggie.blog_app.pagination_criteria.PostPage;
import com.devmeggie.blog_app.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/post")
public class PostController {

    private final PostService postservice;
    private final HttpSession httpSession;

    @PostMapping("/{id}")
    public Post uploadPost(@PathVariable("id") Long categoryId, @RequestBody UpLoadPostDto uploadPostDto) {
        return postservice.uploadPost(uploadPostDto, categoryId);

    }

    @GetMapping("/viewAllPost")
    public Page<Post> viewAllPost(PostPage postPage) {
        return postservice.viewAllPost(postPage);
    }

    @DeleteMapping("/{postId}")
    public String deletePost(@PathVariable("postId") Long postId) {
        postservice.deletePost(postId);
        return "post deleted successfully";
    }

    @GetMapping("/{id}")
    public Post viewPostById(@PathVariable ("id")Long postId){
        return postservice.viewPostById(postId);
    }

}


