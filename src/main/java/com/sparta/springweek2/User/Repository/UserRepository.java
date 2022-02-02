package com.sparta.springweek2.User.Repository;

import com.sparta.springweek2.User.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>
{

    Optional<User> findByNickname(String username);
    Optional<User> findByKakaoId(Long kakaoId);

    List<User> findAll();
}