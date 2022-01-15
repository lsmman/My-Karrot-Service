package com.lsmman.mykarrotservice.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    @Query(
            value = "SELECT * FROM users u WHERE u.email = ?1",
            nativeQuery = true
    )
    Optional<Users> findByEmail(String email);
}
