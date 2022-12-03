package com.devmeggie.blog_app.services;

import com.devmeggie.blog_app.dtos.UpLoadPostDto;
import com.devmeggie.blog_app.models.Post;
import com.devmeggie.blog_app.pagination_criteria.PostPage;
import org.springframework.data.domain.Page;

public interface PostService  {
    Post uploadPost(UpLoadPostDto upLoadPostDto, Long category);

    Page<Post>viewAllPost(PostPage postPage);

    void deletePost(Long postId);
    

}
