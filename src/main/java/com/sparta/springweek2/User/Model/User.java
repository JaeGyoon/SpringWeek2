package com.sparta.springweek2.User.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class User {

    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    // nullable: null 허용 여부
// unique: 중복 허용 여부 (false 일때 중복 허용)
    @Column(nullable = false, unique = true)
    private String nickname;

    @Column(nullable = false)
    private String password;

//    @Column(nullable = false)
//    private String passwordCheck;

    @Column(unique = true)
    private Long kakaoId;

    // 폼 로그인 사용 시
//    public User(String nickname, String password, String passwordCheck)
    public User(String nickname, String password)
    {
        this.nickname = nickname;
        this.password = password;
//        this.passwordCheck = passwordCheck;
        this.kakaoId = null;
    }

    // 카카오 소셜 로그인 사용 시
    public User(String nickname, String password, Long kakaoId)
//    public User(String nickname, String password, String passwordCheck, Long kakaoId)
    {
        this.nickname = nickname;
        this.password = password;
//        this.passwordCheck = passwordCheck;
        this.kakaoId = kakaoId;
    }
}