package com.sparta.springweek2.User.Controller;

import com.sparta.springweek2.User.DTO.FormRegisterDto;
import com.sparta.springweek2.User.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController
{

    private final UserService userService;
//    private final KakaoUserService kakaoUserService;

    @Autowired
//    public UserController(UserService userService, KakaoUserService kakaoUserService)
    public UserController(UserService userService)
    {
        this.userService = userService;
//        this.kakaoUserService = kakaoUserService;
    }

    // 회원 로그인 페이지
    @GetMapping("/user/login")
    public String login()
    {
        return "login";
    }

    // 회원 가입 페이지
    @GetMapping("/user/signup")
    public String signup()
    {
        return "signup";
    }

    // 회원 가입 요청 처리
    @PostMapping("/user/signup")
    public String registerUser(FormRegisterDto requestDto)
    {
        userService.registerUser(requestDto);
        return "redirect:/user/login";
    }
}
