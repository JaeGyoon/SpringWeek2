package com.sparta.springweek2.Comment;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long>
{
    List<Comment> findAllByPostNumOrderByCreatedAtDesc(Long postId);
}
