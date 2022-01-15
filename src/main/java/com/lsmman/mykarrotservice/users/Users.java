package com.lsmman.mykarrotservice.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Length(max = 256)
    @Email
    @Column(
            name = "email",
            nullable = false,
            length = 256,
            unique = true
    )
    private String email;

    @NotNull
    @Length(max = 64)
    @Column(nullable = false, length = 64)
    private String password;

    @Length(max = 32)
    @Column(length = 32)
    private String name;

    @Length(max = 32)
    @Column(name = "nick_name", length = 32)
    private String nickName;

//    // TODO 패턴 validation 추가
//    private String phone_number;
//
//    @URL
//    private String image; // 프로필 이미지
//
//    private String location;

    // TODO 추후 JPA Audit 으로 빼기
    @Column(name = "create_at", updatable = false)
    private LocalDateTime createAt;
}
