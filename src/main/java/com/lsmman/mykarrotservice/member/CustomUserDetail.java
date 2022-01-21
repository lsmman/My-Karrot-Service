package com.lsmman.mykarrotservice.member;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomUserDetail extends User {
    private final Member member;

    public CustomUserDetail(
            String username,
            String password,
            Collection<? extends GrantedAuthority> authorities,
            Member member
    ) {
        super(username, password, authorities);
        this.member = member;
    }

    public Member getMember() {
        return member;
    }
}
