package com.lsmman.mykarrotservice.users.dto;

import com.lsmman.mykarrotservice.users.Users;
import lombok.*;

import javax.validation.constraints.NotEmpty;

// TODO DTO Annotation 빼기
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class SignUpRequestDto {
    // Validation 스택 분리하기
    @NotEmpty
    private String id;

    @NotEmpty
    private String password;


    private String name;
    private String phoneNumber;
    private String nickName;

    public static Users toUsers(SignUpRequestDto signUpRequestDto){
        return Users.builder()
                .email(signUpRequestDto.getId())
                .password(signUpRequestDto.getPassword())
                .name(signUpRequestDto.getName())
                .nickName(signUpRequestDto.getNickName())
                .build();
    }
}
