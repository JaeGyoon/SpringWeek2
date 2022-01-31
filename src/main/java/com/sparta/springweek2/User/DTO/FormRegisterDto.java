package com.sparta.springweek2.User.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FormRegisterDto
{
    private String username;
    private String password;
    private String passwordCheck;

}
