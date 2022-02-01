package com.sparta.springweek2.User.Controller;


import com.sparta.springweek2.User.Model.User;
import com.sparta.springweek2.User.Repository.UserRepository;
import com.sparta.springweek2.User.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor // final로 선언된 멤버 변수를 자동으로 생성합니다.
@RestController // JSON으로 데이터를 주고받음을 선언합니다.
public class UserFindController {

    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping("/user/find")
    public List<User> getUser()
    {
        return userRepository.findAll();
    }

    @PostMapping("/user/signup2")
    public String registerUser2(String nickname, String password, String passwordCheck)
    {
//        userService.registerUser2(nickname,password,passwordCheck);
        return "redirect:/user/login";
    }

}
