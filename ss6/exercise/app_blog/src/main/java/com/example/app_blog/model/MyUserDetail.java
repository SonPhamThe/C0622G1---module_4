package com.example.app_blog.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserDetail implements UserDetails {

    private User user;

    public MyUserDetail(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { // phân quyền
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        for (Role role : user.getRoles()) {
            grantedAuthorityList.add(new SimpleGrantedAuthority(role.getName()));
        }
        return grantedAuthorityList;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() { // xem user có đang hoạt động hay không. Ví dụ: nếu một tài khoản bị ban thì kết quả trả về là false
        return user.isEnabled();
    }
}
