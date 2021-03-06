package com.sparta.springweek2.Security;

import com.sparta.springweek2.User.Model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserDetailsImpl implements UserDetails
{

    private final User user;

    public UserDetailsImpl(User user)
    {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String getUsername()
    {
        return user.getNickname();
    }


    @Override
    public String getPassword()
    {
        return user.getPassword();
    }



    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return Collections.emptyList();
    }
}