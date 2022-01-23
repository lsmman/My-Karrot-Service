package com.lsmman.mykarrotservice.member;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class Member {
    @Id @GeneratedValue
    private Long id;

    @Email
    @NotNull
    private String memberId;

    @NotNull
    private String password;

    private String name;

    private String phoneNumber;

    private String nickName;

    private String profileImagePath = "/images/빈프로필.png";

    private String shortAddress = "동네";

    private String address;

    public Member(String memberId, String password, String name, String phoneNumber, String nickName) {
        this.memberId = memberId;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.nickName = nickName;
    }

    public void setShortAddress(String shortAddress) {
        this.shortAddress = shortAddress;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    // TODO 속성에 validation 추가
    // TODO enum String -> embedded 타입으로 변경 요망
}
