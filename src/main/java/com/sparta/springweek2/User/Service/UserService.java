package com.sparta.springweek2.User.Service;

import com.sparta.springweek2.User.DTO.FormRegisterDto;
import com.sparta.springweek2.User.Model.User;
import com.sparta.springweek2.User.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;
    private static final String ADMIN_TOKEN = "AAABnv/xRVklrnYxKZ0aHgTBcXukeZygoC";

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder)
    {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String registerUser(FormRegisterDto requestDto)
    {
        String nickName = requestDto.getNickname();
        String password = requestDto.getPassword();
        String password2 = requestDto.getPasswordCheck();

        String regex = "^[a-zA-Z0-9]*$";

        if ( nickName.length() < 3)
        {
            return "아이디는 3글자 이상으로 구성되어야 합니다.";
            // alert("아이디는 3글자 이상, 알파벳 대소문자 혹은 숫자로 구성되어야 합니다.");
        }
        else if (!Pattern.matches(regex, nickName))
        {
            return "아이디는 알파벳 대소문자 혹은 숫자로 구성되어야 합니다.";
        }
        else if ( password.length() < 4)
        {
            return "비밀번호는 4글자 이상으로 구성되어야 합니다.";
        }
        else if ( password.contains(nickName))
        {
            return "비밀번호에 닉네임이 포함되어 있습니다.";
        }
        else if ( !password.equals(password2))
        {
            return "비밀번호가 다르게 입력되어 있습니다.";
        }

// 회원 ID 중복 확인
        String nickname = requestDto.getNickname();
        Optional<User> found = userRepository.findByNickname(nickname);

        if (found.isPresent())
        {
            return "중복된 id 입니다.";
        }

// 패스워드 암호화
        String encodingPassword = passwordEncoder.encode(requestDto.getPassword());
//        String passwordCheck = passwordEncoder.encode(requestDto.getPasswordCheck());

//        User user = new User(nickname, password, passwordCheck);
        User user = new User(nickname, encodingPassword);
        userRepository.save(user);

        return "";
    }

    public void registerUser2(String nickname, String password, String passwordCheck)
    {
        String password1 = passwordEncoder.encode(password);
//        String passwordCheck = passwordEncoder.encode(requestDto.getPasswordCheck());


//        User user = new User(nickname, password, passwordCheck);
        User user = new User(nickname, password1);
        userRepository.save(user);
    }


}
