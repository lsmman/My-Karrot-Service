package com.lsmman.mykarrotservice.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UsersRepositoryTest {
    @Autowired
    UsersRepository usersRepository;


    @Test
    void findByEmail() {
        String email = "2@s.d";
        String password = "hi";
        usersRepository.save(
                Users.builder()
                        .email(email)
                        .password(password)
                        .build());

        Optional<Users> byEmail = usersRepository.findByEmail(email);

        assertTrue(byEmail.isPresent());
        assertEquals(email, byEmail.get().getEmail());
        assertEquals(password, byEmail.get().getPassword());
    }

}