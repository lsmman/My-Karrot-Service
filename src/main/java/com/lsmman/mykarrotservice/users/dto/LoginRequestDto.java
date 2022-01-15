package com.lsmman.mykarrotservice.users.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class LoginRequestDto {
    @NotEmpty
    private String id;
    @NotEmpty
    private String password;
}
