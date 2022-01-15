package com.lsmman.mykarrotservice.users;

import com.lsmman.mykarrotservice.users.dto.LoginRequestDto;
import com.lsmman.mykarrotservice.users.dto.SignUpRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;

    @PostMapping("/users/sign-up")
    public ResponseEntity<?> signUp(@RequestBody SignUpRequestDto signUpRequestDto){
        if (usersService.isDuplicatedUserId(signUpRequestDto.getId())){
            ResponseEntity.status(HttpStatus.CONFLICT).body("이미 가입된 계정입니다.");
        }
        usersService.registerUser(SignUpRequestDto.toUsers(signUpRequestDto));
        return ResponseEntity.ok().build();
    }

    @PostMapping("/users/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequestDto){
        if (!usersService.isDuplicatedUserId(loginRequestDto.getId())){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("가입되지 않은 계정입니다.");
        }
        if (!usersService.isPasswordMatched(loginRequestDto.getId(), loginRequestDto.getPassword())){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("패스워드가 맞지 않습니다.");
        }

        // TODO 로그인시 JWT 토큰 만들기
        return ResponseEntity.ok().body("token");
    }

    @PostMapping("/users/logout")
    public ResponseEntity<?> logout(){
        return null;
    }


}
