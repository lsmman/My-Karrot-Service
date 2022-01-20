package com.lsmman.mykarrotservice.member;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class Member {

    @Id @GeneratedValue
    private Long id;

    @Email
    private String memberId;

    private String password;

    private String name;

    private String phoneNumber;

    private String nickName;

    public Member(Long id, String memberId, String password, String name, String phoneNumber, String nickName) {
        this.id = id;
        this.memberId = memberId;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.nickName = nickName;
    }

    public void encodePassword(String password) {
        this.password = password;
    }

}
