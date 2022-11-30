package com.devmeggie.blog_app.services.servicesImpl;

import com.devmeggie.blog_app.dtos.UserLogInDto;
import com.devmeggie.blog_app.dtos.UserSignUpDto;
import com.devmeggie.blog_app.enums.Gender;
import com.devmeggie.blog_app.enums.Role;
import com.devmeggie.blog_app.exceptions.AlreadyExistException;
import com.devmeggie.blog_app.models.User;
import com.devmeggie.blog_app.repositories.UserRepo;
import com.devmeggie.blog_app.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    private final HttpSession httpSession;

    @Override
    public User signUp(UserSignUpDto userSignUpDto) {
        String userEmail = userSignUpDto.getEmail();
        boolean users = userRepo.existsByEmail(userEmail);
        if (users) {
            throw new AlreadyExistException("Already exist");
        }
        User user = new User();
        user.setEmail(userSignUpDto.getEmail());
        user.setFirstName(userSignUpDto.getFirstName());
        user.setLastName(userSignUpDto.getLastName());
        user.setPassword(userSignUpDto.getPassword());
        user.setRole(Role.ADMIN);
        user.setGender(Gender.MALE);
        user.setPost(new ArrayList<>());
        userRepo.save(user);
        return user;
    }

    @Override
    public User logIn(UserLogInDto userLoginDto) {

        String email = userLoginDto.getEmail();
        String password = userLoginDto.getPassword();

        User user = userRepo.findByEmailAndPassword(email, password);
        if (user.getEmail().equals(user.getPassword())) {
        }
        return user;
    }

    @Override
    public String logOut() {
        httpSession.invalidate();
        return "user Logged Out";
    }
    


































//    @Override
//    public String deleteUser() {
//        Long user_id = (Long) httpSession.getAttribute("user_id");
//        boolean exists = userRepo.existsById(user_id);
//        userRepo.deleteById(user_id);
//        return "user deleted";

          //  throw new NotFoundException("not found");
        }
//        userRepo.deleteById(user_id);
//        return "user deleted";




//        String email = userLoginDto.getEmail();
//        String password = userLoginDto.getPassword();
//
//        User user = userRepo.findByEmail(email).orElseThrow(()-> new NotFoundException("not found"));
//
//        if(!user.getPassword().equals(password)){
//          //  throw new NotFoundException("user not found");
//        }
//        httpSession.setAttribute("user_id",user.getId());
//        httpSession.setAttribute("Permission", "user");
//
//        return "successfully signed In";


//        boolean dbUser = userRepo.existsByEmail(email);
//        User existingDbUser = userRepo.findByEmailAndPassword(email,password);
//
//
//        if(email.isEmpty() || password.isEmpty()){
//            throw new UnauthorizedException("Unauthorized");
//        }
//        if(!dbUser){
//            throw new NotFoundException("user with " + email + password + " does not exist");
//        }
//        if(!existingDbUser.getEmail().equals(email)){
//            throw new UnauthorizedException("email or password Incorrect");
//        }
//        httpSession.setAttribute("user_id",existingDbUser.getId());
//        httpSession.setAttribute("permission","User");
//
//        return userLoginDto;


//
//                String email = userLoginDto.getEmail();
//        String password = userLoginDto.getPassword();
//
//        User user = userRepo.findByEmailAndPassword(email, password);
//        if (user.getEmail().equals(user.getPassword())) {
//        }
//        return userLoginDto;
//    }






//    @Override
//    public String deleteUser() {
//        return "User logged";
//    }
//}
