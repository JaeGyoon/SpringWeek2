package com.sparta.springweek2.User.Service;

import com.sparta.springweek2.User.DTO.FormRegisterDto;
import com.sparta.springweek2.User.Model.User;
import com.sparta.springweek2.User.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private static final String ADMIN_TOKEN = "AAABnv/xRVklrnYxKZ0aHgTBcXukeZygoC";

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(FormRegisterDto requestDto)
    {
// 회원 ID 중복 확인
        String nickname = requestDto.getNickname();
        Optional<User> found = userRepository.findByNickname(nickname);

        if ( nickname.length() < 3)
        {
            throw new IllegalArgumentException("최소 3자 이상의 닉네임을 입력해주세요.");
        }


        if (found.isPresent())
        {
            throw new IllegalArgumentException("중복된 닉네임입니다.");
        }

// 패스워드 암호화
        String password = passwordEncoder.encode(requestDto.getPassword());
//        String passwordCheck = passwordEncoder.encode(requestDto.getPasswordCheck());


//        User user = new User(nickname, password, passwordCheck);
        User user = new User(nickname, password);
        userRepository.save(user);
    }
}
