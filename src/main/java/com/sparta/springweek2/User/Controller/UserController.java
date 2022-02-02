package com.sparta.springweek2.User.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sparta.springweek2.Security.UserDetailsImpl;
import com.sparta.springweek2.User.DTO.FormRegisterDto;
import com.sparta.springweek2.User.Model.User;
import com.sparta.springweek2.User.Repository.UserRepository;
import com.sparta.springweek2.User.Service.KakaoUserService;
import com.sparta.springweek2.User.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class UserController
{

    private final UserService userService;

    private final KakaoUserService kakaoUserService;

    @Autowired
    public UserController(UserService userService, KakaoUserService kakaoUserService)
//    public UserController(UserService userService, UserRepository userRepository)
    {
        this.userService = userService;
        this.kakaoUserService = kakaoUserService;
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
    public String registerUser(FormRegisterDto requestDto , Model model)
    {
        if (userService.registerUser(requestDto).equals("회원가입 완료"))
        {
            return "login";
        }
        else
        {
            model.addAttribute("errortext", userService.registerUser(requestDto));
            return "signup";
        }
    }


    // 카카오 콜백
    @GetMapping("/user/kakao/callback")
    public String kakaoLogin(@RequestParam String code) throws JsonProcessingException
    {
        // authorizedCode: 카카오 서버로부터 받은 인가 코드
        kakaoUserService.kakaoLogin( code);
        return "redirect:/";
    }


    @GetMapping("/post/post")
    public String WritePage()
    {
        return "write";
    }



}
