package com.sparta.springweek2.Comment;

import lombok.Getter;

@Getter
public class CommentRequestDto
{
    private Long postNum;
    private String userName;
    private String commentText;
}
