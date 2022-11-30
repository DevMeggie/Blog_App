package com.devmeggie.blog_app.services.servicesImpl;

import com.devmeggie.blog_app.dtos.UpLoadPostDto;
import com.devmeggie.blog_app.enums.Role;
import com.devmeggie.blog_app.exceptions.UnauthorizedException;
import com.devmeggie.blog_app.models.Post;
import com.devmeggie.blog_app.models.User;
import com.devmeggie.blog_app.repositories.PostRepo;
import com.devmeggie.blog_app.services.UserService;
import com.devmeggie.blog_app.utils.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class PostServiceImpl {

    private final PostRepo postRepo;
    private final HttpSession httpSession;
    private final UserService userService;
    private final Util util;


    public void uploadPost(UpLoadPostDto upLoadPostDto) {
        Long userId = util.loggedInUserById();
        User user = util.findUserById(userId);

        if (!user.getRole().equals(Role.ADMIN)) {
            throw new UnauthorizedException("Sorry! you do not have access");
        }
        Post post = Post.builder()
                .title(upLoadPostDto.getTitle())
                .content(upLoadPostDto.getContent())
                .imageUrl(upLoadPostDto.getImageUrl())
                .comment(new ArrayList<>())
                .build();
        postRepo.save(post);

    }
}


