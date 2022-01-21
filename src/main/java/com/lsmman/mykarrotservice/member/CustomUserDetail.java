package com.lsmman.mykarrotservice.member;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomUserDetail extends User {
    private final Long id;

    public CustomUserDetail(
            String username,
            String password,
            Collection<? extends GrantedAuthority> authorities,
            Long id
    ) {
        super(username, password, authorities);
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
