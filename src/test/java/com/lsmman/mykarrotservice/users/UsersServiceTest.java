package com.lsmman.mykarrotservice.users;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UsersServiceTest {
    @Mock
    UsersRepository usersRepository;

    @InjectMocks
    UsersService usersService;


    String email = "test@email.net";
    String password = "hello";

    Users build = Users.builder()
            .email(email)
            .password(password)
            .build();

    @BeforeEach
    void setUp() {
        usersRepository.save(build);

        when(usersRepository.findByEmail(anyString())).thenReturn(Optional.empty());
        when(usersRepository.findByEmail(email)).thenReturn(Optional.of(build));
    }

    @Test
    void checkDuplicatedUserId() {
        assertTrue(usersService.isDuplicatedUserId(email));
    }

//    @Test
//    void registerUser() {
//
//    }

    @Test
    void isPasswordMatched() {
        assertTrue(usersService.isPasswordMatched(email, password));
    }

    @Test
    void isPasswordMatchedPasswordError() {
        assertFalse(usersService.isPasswordMatched(email, password + "hi"));
    }
}