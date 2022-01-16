package com.lsmman.mykarrotservice.users;

import com.lsmman.mykarrotservice.users.dto.SignUpRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;

    public boolean isDuplicatedUserId(@NotEmpty String email) {
        Optional<Users> exist = usersRepository.findByEmail(email);
        return exist.isPresent();
    }

    public void registerUser(Users users) {
        usersRepository.save(users);
    }

    public boolean isPasswordMatched(String email, String password) {
        Optional<Users> byEmail = usersRepository.findByEmail(email);
        return byEmail.isPresent() && Objects.equals(password, byEmail.get().getPassword());
    }
}
