package com.devmeggie.blog_app.services.servicesImpl;

import com.devmeggie.blog_app.dtos.UserLogInDto;
import com.devmeggie.blog_app.dtos.UserSignUpDto;
import com.devmeggie.blog_app.enums.Gender;
import com.devmeggie.blog_app.enums.Role;
import com.devmeggie.blog_app.exceptions.NotFoundException;
import com.devmeggie.blog_app.models.User;
import com.devmeggie.blog_app.repositories.UserRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.http.HttpSession;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class UserServiceImplTest {
    @Mock
    UserRepo testUserRepo;

    @Mock
    HttpSession httpSession;

    @InjectMocks
    UserServiceImpl testUserServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    User user = new User("maggie04@yahoo.com","maggie","martins",
            "maggie123", Gender.MALE, Role.ADMIN,new ArrayList<>());

    UserSignUpDto userSignUpDto = new UserSignUpDto("maggie04@yahoo.com","maggie","martins",
            "maggie123",Role.ADMIN,Gender.MALE);

    UserLogInDto userLogInDto = new UserLogInDto("maggie04@yahoo.com","maggie123");

    @Test
    void UserSignUp() {
        when(testUserRepo.existsByEmail(anyString())).thenReturn(false);
        when(testUserRepo.save(any())).thenReturn(user);
        User result = testUserServiceImpl.signUp(userSignUpDto);

        Assertions.assertEquals(user.getEmail(),result.getEmail());
        Assertions.assertEquals(user.getFirstName(),result.getFirstName());
        Assertions.assertEquals(user.getLastName(),result.getLastName());
        Assertions.assertEquals(user.getPassword(),result.getPassword());
        Assertions.assertEquals(user.getRole(),result.getRole());
        Assertions.assertEquals(user.getGender(),result.getGender());
    }


    @Test
    void logIn() {
        when(testUserRepo.existsByEmail(anyString())).thenReturn(true);
        Assertions.assertThrows(NotFoundException.class, ()->testUserServiceImpl.logIn(userLogInDto));
    }

    @Test
    void logOut() {
        String result = testUserServiceImpl.logOut();
        String expected = "user Logged Out";
        Assertions.assertEquals(expected, result);
    }
}