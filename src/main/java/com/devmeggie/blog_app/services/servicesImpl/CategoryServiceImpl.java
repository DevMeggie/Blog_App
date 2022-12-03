package com.devmeggie.blog_app.services.servicesImpl;

import com.devmeggie.blog_app.enums.Role;
import com.devmeggie.blog_app.exceptions.AlreadyExistException;
import com.devmeggie.blog_app.exceptions.UnauthorizedException;
import com.devmeggie.blog_app.models.Category;
import com.devmeggie.blog_app.models.User;
import com.devmeggie.blog_app.repositories.CategoryRepo;
import com.devmeggie.blog_app.services.CategoryService;
import com.devmeggie.blog_app.services.UserService;
import com.devmeggie.blog_app.utils.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    public final HttpSession httpSession;
    public final UserService userService;
    public final CategoryRepo categoryRepo;
    public final Util util;

    @Override
    public void createCategory(Category category) {
        Long userId = util.loggedInUserById();
        User user = util.findUserById(userId);

        if(!user.getRole().equals(Role.ADMIN)){
            throw new UnauthorizedException("Oops! Admin only");
        }
        if(categoryRepo.existsByName(category.getName())){
            throw new AlreadyExistException("this category already exist");
        }
        Category category1 = Category.builder()
                .name(category.getName())
                .build();
        categoryRepo.save(category1);

    }
}
