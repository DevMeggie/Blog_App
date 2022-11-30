package com.devmeggie.blog_app.controllers;

import com.devmeggie.blog_app.repositories.PostRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostRepo postRepo;
    private final HttpSession httpSession;

}
