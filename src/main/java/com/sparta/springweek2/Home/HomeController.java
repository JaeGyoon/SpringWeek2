package com.sparta.springweek2.Home;


import com.sparta.springweek2.Security.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController
{
    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails)
    {
        if (userDetails != null)
        {
            model.addAttribute("nickname", userDetails.getUsername());
            return "index2";
        }

        return "index2";
    }
}